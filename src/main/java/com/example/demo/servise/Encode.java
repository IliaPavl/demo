package com.example.demo.servise;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Encode {
    private final String alg = "SHA3-256";

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    public String makeCode(String string) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        String s=string+new Date(System.currentTimeMillis());
        byte[] hashbytes = digest.digest(s.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hashbytes);
    }
}
