package ru.hackathon.chatBot17;

import org.junit.Assert;
import org.junit.Test;
import ru.hackathon.chatBot17.services.security.CryptingServiceImpl;

import java.io.UnsupportedEncodingException;

public class CodingTest {

    private CryptingServiceImpl codingWordImpl = new CryptingServiceImpl();

    @Test
    public void codingDecoding() throws UnsupportedEncodingException {
        String codingPassword = codingWordImpl.encrypt("qwerty321F;");
        String decodingPassword = codingWordImpl.decrypt(codingPassword);

        Assert.assertEquals("5428d4b6f085d1f84bd73f0cc34b0c6c", codingPassword);
        Assert.assertEquals("qwerty321F;", decodingPassword);
    }

}
