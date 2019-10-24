package ru.hackathon.chatBot17.services.security;

import java.io.UnsupportedEncodingException;

/**
 * Interface provides of methods for coding/decoding a words
 */
public interface CodingWord {

    /**
     * Coding a word
     *
     * @param word word
     * @return coded word
     */
    String encrypt(String text);

    /**
     * Decoding a coded word
     *
     * @param codingWord coded word
     * @return decoded word
     */
    String decrypt(String text);
}
