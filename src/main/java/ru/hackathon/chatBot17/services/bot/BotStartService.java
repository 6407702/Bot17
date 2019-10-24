package ru.hackathon.chatBot17.services.bot;

import java.util.concurrent.ExecutionException;

/**
 * Service provides operation connected with Bot API.
 */
public interface BotStartService {

    /**
     * Start a Chat-Bot
     * @param host Host of Chat
     * @param port Port of Chat
     * @param token Credentials of a Bot which registered in the Chat
     * */
    void start(String host, Integer port, String token) throws ExecutionException, InterruptedException;
}
