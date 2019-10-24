package ru.hackathon.chatBot17;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.hackathon.chatBot17.services.api.SshServerImpl;
import ru.hackathon.chatBot17.services.api.SshService;

@SpringBootTest
public class ChatBot17ApplicationTests {

	@Test
	public void testSshCommandUptime() throws Exception {
		SshService sshService = new SshServerImpl();
		String result = sshService.runCommand("62.109.7.2", "bot", "", "uptime");
		System.out.println(result);

		Assert.assertNotNull(result);
	}
}
