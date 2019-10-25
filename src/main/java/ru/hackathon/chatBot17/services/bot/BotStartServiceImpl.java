package ru.hackathon.chatBot17.services.bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import im.dlg.botsdk.Bot;
import im.dlg.botsdk.BotConfig;
import ru.hackathon.chatBot17.services.common.ProcessCommandService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Implementation of a service which provides operation connected with Bot API.
 */
@Service
public class BotStartServiceImpl implements BotStartService {

    @Autowired
    private ProcessCommandService processCommand;

    /**
     * @inheritDoc
     */
    @Override
    public void start(String host, Integer port, String token) throws ExecutionException, InterruptedException {

        AtomicReference<String> answer = new AtomicReference();

        //connect
        BotConfig botConfig = BotConfig.Builder.aBotConfig()
                .withHost(host)
                .withPort(port)
                .withToken(token)
                .build();

        Bot bot = Bot.start(botConfig).get();

        //processing
        bot.messaging().onMessage(message ->
                bot.users().get(message.getSender()
                ).thenAccept(userOpt -> userOpt.ifPresent(user -> {
                    //[0] process a user message
                    try {
                        answer.set(processCommand.processCommand(message.getText()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("Got a message: " + message.getText() + " from user: " + user.getName());
                })
                ).thenCompose(aVoid -> {
                    //[1] send response to User
                    return bot.messaging().sendText(message.getPeer(), answer.get());
                }
                ).exceptionally(ex -> {
                    //[2] Exception
                    ex.printStackTrace();
                    return null;
                }).thenAccept(uuid -> {
                    //[3] message was proceed
                    System.out.println("Sent a message with UUID: " + uuid);
                }));

        bot.await();
    }
}
