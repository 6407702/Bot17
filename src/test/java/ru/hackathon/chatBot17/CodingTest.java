package ru.hackathon.chatBot17;

import org.junit.Assert;
import org.junit.Test;
import ru.hackathon.chatBot17.services.security.CodingWord;

public class CodingTest {

    private CodingWord codingWord = new CodingWord("112341421241214123141241".getBytes());

    @Test
    public void codingDecoding() {
        String codingPassword = codingWord.coding("password");
        String decodingPassword = codingWord.decoding(codingPassword);

        Assert.assertEquals("ЮУсZBwxj\fаЁі\txnЎ", codingPassword);
        Assert.assertEquals("password", decodingPassword);
    }
}
