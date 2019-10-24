package ru.hackathon.chatBot17.services.api;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.QueueReference;
import org.springframework.stereotype.Service;
import ru.hackathon.chatBot17.common.ParsedCommand;

import java.net.URI;
import java.util.Map;

@Service
public class JenkinsServiceImpl implements JenkinsService {

    @Override
    public String process(ParsedCommand parsedCommand) throws Exception {
        JenkinsServer jenkins = new JenkinsServer(new URI("http://172.30.12.104:8080"), "Admin", "qwerty321");
        Map<String, Job> jobs = jenkins.getJobs();
        Job job17 = jenkins.getJob("bot17");
        QueueReference ref = job17.build();
        return "OK, Jenkins job is building";
    }
}
