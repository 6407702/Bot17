package ru.hackathon.chatBot17.services.security;

import java.io.UnsupportedEncodingException;

/**
 * Interface provides of methods for coding/decoding a words
 */
public interface CryptingService {

    /**
     * Coding a word
     *
     * @param text word
     * @return coded word
     */
    String encrypt(String text);

    /**
     * Decoding a coded word
     *
     * @param text coded word
     * @return decoded word
     */
    String decrypt(String text);
}
