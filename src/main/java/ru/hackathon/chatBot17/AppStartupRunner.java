package ru.hackathon.chatBot17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.hackathon.chatBot17.services.bot.BotStartService;

/**
 * Class launches a ChatBot after application was started.
 */
@Component
public class AppStartupRunner implements ApplicationRunner {

    @Value("${chat.host}")
    private String host;

    @Value("${chat.port}")
    private Integer port;

    @Value("${chat.bot.token}")
    private String token;

    @Autowired
    private BotStartService botStartService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        botStartService.start(host, port, token);
    }
}