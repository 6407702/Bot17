package ru.hackathon.chatBot17;

import org.junit.Assert;
import org.junit.Test;
import ru.hackathon.chatBot17.services.security.CodingWordImpl;

public class CodingTest {

    private CodingWordImpl codingWordImpl = new CodingWordImpl("112341421241214123141241".getBytes());

    @Test
    public void codingDecoding() {
        String codingPassword = codingWordImpl.coding("password");
        String decodingPassword = codingWordImpl.decoding(codingPassword);

        Assert.assertEquals("ЮУсZBwxj\fаЁі\txnЎ", codingPassword);
        Assert.assertEquals("password", decodingPassword);
    }

    @Test
    public void coDecodeTest() {
        String decodingPassword = codingWordImpl.decoding(codingWordImpl.coding("qweqda"));

        Assert.assertEquals("qweqda", decodingPassword);
    }
}
