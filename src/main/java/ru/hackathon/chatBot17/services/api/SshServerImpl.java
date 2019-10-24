package ru.hackathon.chatBot17.services.api;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hackathon.chatBot17.services.security.SecurityChecks;
import ru.hackathon.chatBot17.services.security.SecurityChecksImpl;


import java.util.Scanner;

/**
 * Service provides operation with SSL connection
 */
@Service
public class SshServerImpl implements SshService {

    @Autowired
    private SecurityChecks securityChecks = new SecurityChecksImpl();

    /**
     * @inheritDoc
     */
    @Override
    public String runCommand(String serverIp, String login, String pass, String command)  throws Exception {
        String result;

        //[0] check
        if (!securityChecks.checkSshCommand(command)) {
            return "Command '" + command + "' will not be run because of security rules.";
        }

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
