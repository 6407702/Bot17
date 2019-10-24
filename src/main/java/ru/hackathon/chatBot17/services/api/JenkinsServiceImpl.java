package ru.hackathon.chatBot17.services.api;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.QueueReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hackathon.chatBot17.common.ParsedCommand;
import ru.hackathon.chatBot17.db.entity.Server;
import ru.hackathon.chatBot17.db.service.ServerService;
import ru.hackathon.chatBot17.services.security.CryptingService;
import ru.hackathon.chatBot17.services.security.SecurityChecksService;

import java.net.URI;
import java.util.Map;

@Service
public class JenkinsServiceImpl implements JenkinsService {
    private static final String JENKINS_SERVER_CODE = "JENKINS";
    @Autowired
    SecurityChecksService securityChecks;

    @Autowired
    ServerService serverService;

    @Autowired
    CryptingService cryptingService;

    @Override
    public String process(ParsedCommand parsedCommand) throws Exception {
        if (!securityChecks.checkJenkinsCommand(parsedCommand.getCommand())) {
            return "Command '" + parsedCommand.getCommand() + "' will not be run because of security rules.";
        }

        Server server = serverService.findByCode(JENKINS_SERVER_CODE);
        String uriString = "http://" + server.getIp() + ":" + server.getPort();
        String login = server.getTechUser().getLogin();
        String encryptedToken = server.getTechUser().getPass();
        String token = cryptingService.decrypt(encryptedToken);
        JenkinsServer jenkins = new JenkinsServer(new URI(uriString), login, token);

        String command = parsedCommand.getCommand();
        if (command != null && !command.isEmpty()) {
            if ("build".equals(command)) {
                Job job = jenkins.getJob(parsedCommand.getArgument());
                if (job != null) {
                    job.build();
                    return "Jenkins job (" + parsedCommand.getArgument() + ") is building";
                }
                return "Jenkins job (" + parsedCommand.getArgument() + ") doesn't exist";
            } else if ("status".equals(command)) {
                Job job = jenkins.getJob(parsedCommand.getArgument());
                if (job != null) {
                    String result = job.details().getLastBuild().details().getResult().name();
                    String fullDispayName = job.details().getLastBuild().details().getFullDisplayName();
                    return "Jenkins job (" + fullDispayName + ") result is " + result;
                }
                return "Jenkins job (" + parsedCommand.getArgument() + ") doesn't exist";
            }
        }

        return "incorrect jenkins command";
    }
}
