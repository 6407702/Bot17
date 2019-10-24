package ru.hackathon.chatBot17.services;

import java.util.concurrent.ExecutionException;

public interface BotStartService {
    void start(String host, Integer port, String token) throws ExecutionException, InterruptedException;
}
