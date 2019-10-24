package ru.hackathon.chatBot17;

import org.junit.Assert;
import org.junit.Test;
import ru.hackathon.chatBot17.services.security.CodingWordImpl;

import java.io.UnsupportedEncodingException;

public class CodingTest {

    private CodingWordImpl codingWordImpl = new CodingWordImpl();

    @Test
    public void codingDecoding() throws UnsupportedEncodingException {

       /* DesedeCrypter crypter = new DesedeCrypter();
        String codingPassword = crypter.encrypt("password");
        String encrypted = crypter.decrypt(codingPassword);*/
        String codingPassword = codingWordImpl.encrypt("password");
        String decodingPassword = codingWordImpl.decrypt(codingPassword);

        Assert.assertEquals("3cf9fe8acf974b02", codingPassword);
        Assert.assertEquals("password", decodingPassword);
    }

    @Test
    public void coDecodeTest() {
        String decodingPassword = codingWordImpl.decoding(codingWordImpl.coding("qweqda"));

        Assert.assertEquals("qweqda", decodingPassword);
    }
}
