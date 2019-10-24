import im.dlg.botsdk.Bot;
import im.dlg.botsdk.BotConfig;

import java.util.concurrent.ExecutionException;

public class Main {
    private static final String TOKEN_BOT17 = "fd38fb9c803481ff18e242a1bc57a3d997c64ea3";
    private static final String HOST = "hackathon-mob.transmit.im";
    private static final int PORT = 443;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        BotConfig botConfig = BotConfig.Builder.aBotConfig()
                .withHost(HOST)
                .withPort(PORT)
                .withToken(TOKEN_BOT17)
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