package ru.hackathon.chatBot17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.hackathon.chatBot17.services.BotStartService;

@Component
public class AppStartupRunner implements ApplicationRunner {

    private static final String TOKEN_BOT17 = "fd38fb9c803481ff18e242a1bc57a3d997c64ea3";
    private static final String HOST = "hackathon-mob.transmit.im";
    private static final int PORT = 443;

    @Autowired
    private BotStartService botStartService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        botStartService.start(HOST, PORT, TOKEN_BOT17);
    }
}