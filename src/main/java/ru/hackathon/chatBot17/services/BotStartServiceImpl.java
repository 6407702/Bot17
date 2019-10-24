package ru.hackathon.chatBot17.services;
import org.springframework.stereotype.Service;
import im.dlg.botsdk.Bot;
import im.dlg.botsdk.BotConfig;

import java.util.concurrent.ExecutionException;


@Service
public class BotStartServiceImpl implements BotStartService {

    @Override
    public void start(String host, Integer port, String token) throws ExecutionException, InterruptedException {

        BotConfig botConfig = BotConfig.Builder.aBotConfig()
                .withHost(host)
                .withPort(port)
                .withToken(token)
                .build();

        Bot bot = Bot.start(botConfig).get();

        bot.messaging().onMessage(message ->
                bot.users().get(message.getSender()
                ).thenAccept(userOpt -> userOpt.ifPresent(user -> {
                            System.out.println("Got a message: " + message.getText() + " from user: " + user.getName());
                        })
                ).thenCompose(aVoid -> {
                            return bot.messaging().sendText(message.getPeer(), "pong");
                        }
                ).exceptionally(ex -> {
                    ex.printStackTrace();
                    return null;
                }).thenAccept(uuid ->
                        System.out.println("Sent a message with UUID: " + uuid)));

        bot.await();
    }
}
