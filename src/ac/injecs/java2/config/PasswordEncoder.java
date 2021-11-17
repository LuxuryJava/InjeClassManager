package ac.injecs.java2.config;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class PasswordEncoder {

    public static Optional<String> encode(String password) {
        // sha256
        String sha = null;

        try {
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(password.getBytes(StandardCharsets.UTF_8));
            byte[] byteData = sh.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++){
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            sha = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Encrypt Error : " + e.getMessage());
        }

        return Optional.ofNullable(sha);
    }
}
