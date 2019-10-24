package ru.hackathon.chatBot17;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.QueueReference;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.hackathon.chatBot17.services.api.SshServerImpl;
import ru.hackathon.chatBot17.services.api.SshService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@SpringBootTest
public class ChatBot17ApplicationTests {

	@Test
	public void testSshCommandUptime() throws Exception {
		SshService sshService = new SshServerImpl();
		//String result = sshService.runCommand("62.109.7.2", "bot", "", "uptime");
		//System.out.println(result);

		//Assert.assertNotNull(result);
	}

	@Test
	public void testJenkinsClient() throws URISyntaxException, IOException {
		JenkinsServer jenkins = new JenkinsServer(new URI("http://172.30.12.104:8080"), "Admin", "11d43c4219237cd986bcf6d0d6df04490b");
		Map<String, Job> jobs = jenkins.getJobs();
		Job job17 = jenkins.getJob("bot17");
		QueueReference ref = job17.build();
	}
}
