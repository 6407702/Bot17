package ru.hackathon.chatBot17.services.security;

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
    String coding(String word);

    /**
     * Decoding a coded word
     *
     * @param codingWord coded word
     * @return decoded word
     */
    String decoding(String codingWord);
}
