package ru.hackathon.chatBot17.services.security;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Class for coding a words
 */
public class CodingWord implements CodingWordImpl {

    private byte[] key = "asdaFAF1faasdAsdsd4fQAd1".getBytes();

    public CodingWord() {
    }

    public CodingWord(byte[] key) {
        this.key = key;
    }

    @Override
    public String coding(String word) {
        DESedeKeySpec spec; //Define Triple DES class
        byte[] data = word.getBytes();
        byte[] CipherText = new byte[0];

        try {
            spec = new DESedeKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("desede"); //Create secret key using DESede
            Key desKey = keyFactory.generateSecret(spec); //Generate secret key
            Cipher cipher = Cipher.getInstance("DESede" + "/ECB/PKCS5Padding"); //Algorithm and encryption method DESede/ECB/PKCS5Padding(168)
            cipher.init(Cipher.ENCRYPT_MODE, desKey);
            CipherText = cipher.doFinal(data); //Encrypt
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return new String(CipherText);
    }

    @Override
    public String decoding(String CipherText) {
        DESedeKeySpec spec; //Define Triple DES class
        byte[] plaintext = new byte[0];

        try {
            spec = new DESedeKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("desede"); //Create secret key using DESede
            Key desKey = keyFactory.generateSecret(spec); //Generate secret key
            Cipher cipher = Cipher.getInstance("DESede" + "/ECB/PKCS5Padding"); //Algorithm and encryption method DESede/ECB/PKCS5Padding(168)
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            plaintext = cipher.doFinal(CipherText.getBytes()); //Decrypt
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return new String(plaintext);
    }
}