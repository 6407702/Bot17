package ru.hackathon.chatBot17.services.api;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hackathon.chatBot17.common.ParsedCommand;
import ru.hackathon.chatBot17.db.entity.Server;
import ru.hackathon.chatBot17.db.entity.TechUser;
import ru.hackathon.chatBot17.db.service.ServerService;
import ru.hackathon.chatBot17.services.security.CodingWord;
import ru.hackathon.chatBot17.services.security.SecurityChecksService;
import java.util.Scanner;

/**
 * Service provides operation with SSL connection
 */
@Service
public class SshServerImpl implements SshService {

    @Autowired
    ServerService serverService;

    @Autowired
    CodingWord codingWord;

    @Autowired
    SecurityChecksService securityChecks;

    /**
     * @inheritDoc
     */
    @Override
    public String process(ParsedCommand parsedCommand) throws Exception {
        //[0] check
        if (!securityChecks.checkSshCommand(parsedCommand.getCommand())) {
            return "Command '" + parsedCommand.getCommand() + "' will not be run because of security rules.";
        }

        //[1] find server
        Server server = serverService.findByCode(parsedCommand.getArgument().toUpperCase());
        if (server != null) {
            //[2] run command
            TechUser techUser = server.getTechUser();
            if (techUser != null) {
                return runCommand(server.getIp(), techUser.getLogin(),
                                  codingWord.decrypt(techUser.getPass()),
                                  parsedCommand.getCommand());
            } else {
                throw new Exception("Server with a code: " + server.getCode() +
                                    " does not have a default tech user. " +
                                    " Contact with the Administrator to do it.");
            }
        } else {
            return "Server code '" + parsedCommand.getArgument() + "' is not registered. " +
                   "Please, contact with your Administrator. ";
        }
    }

    /**
     * Run a command and return a result.
     * @param serverIp address of the server
     * @param login login of technical user
     * @param pass password of technical user
     * @param command text of a command
     * @return result of the command or error text
     * */
    private String runCommand(String serverIp, String login, String pass, String command)  throws Exception {
        String result;

        //[1] try to connect
        Connection sshConnection = new Connection(serverIp);
        sshConnection.connect();

        //[2] try to authorize
        if (sshConnection.authenticateWithPassword(login, pass)) {
            // [3] execute command
            Session sshSession = sshConnection.openSession();
            sshSession.execCommand(command);

            result = getResultText(sshSession);

            //[4] close
            sshSession.close();
            sshConnection.close();
        } else {
            throw new Exception("Authentication failed.");
        }

        return result;
    }

    /**
    * Read result text from ssh session
    * */
    private String getResultText(Session session) {
        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(session.getStdout());
        while (scanner.hasNext()) {
            result.append(scanner.next());
            result.append(" ");
        }
        return result.toString().trim();
    }
}
