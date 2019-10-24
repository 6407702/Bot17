package ru.hackathon.chatBot17;

import org.junit.Assert;
import org.junit.Test;
import ru.hackathon.chatBot17.services.security.CryptingServiceImpl;

import java.io.UnsupportedEncodingException;

public class CodingTest {

    private CryptingServiceImpl codingWordImpl = new CryptingServiceImpl();

    @Test
    public void codingDecoding() throws UnsupportedEncodingException {
        String codingPassword = codingWordImpl.encrypt("drowss1!");
        String decodingPassword = codingWordImpl.decrypt(codingPassword);

        Assert.assertEquals("3cf9fe8acf974b02", codingPassword);
        Assert.assertEquals("password", decodingPassword);
    }

}
