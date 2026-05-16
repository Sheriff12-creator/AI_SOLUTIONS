package util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class TokenUtil {

    private static final String SECRET_KEY =
            "AI_SOLUTIONS_SECRET_2026";

    public static String generateToken(int adminId) {

        try {

            SecureRandom random = new SecureRandom();

            byte[] bytes = new byte[32];

            random.nextBytes(bytes);

            String randomPart = Base64.getUrlEncoder()
                    .withoutPadding()
                    .encodeToString(bytes);

            long expiry =
                    System.currentTimeMillis() + (2 * 60 * 1000);

            String data =
                    adminId + "." + randomPart + "." + expiry;

            String signature = generateSignature(data);

            return data + "." + signature;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean validateToken(String token) {

        try {

            String[] parts = token.split("\\.");

            if(parts.length != 4) {
                return false;
            }

            String adminId = parts[0];
            String random = parts[1];
            String expiry = parts[2];
            String signature = parts[3];

            String data =
                    adminId + "." + random + "." + expiry;

            String expectedSignature =
                    generateSignature(data);

            if(!expectedSignature.equals(signature)) {
                return false;
            }

            long expiryTime = Long.parseLong(expiry);

            return System.currentTimeMillis()
                    <= expiryTime;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private static String generateSignature(String data)
            throws Exception {

        Mac sha256Hmac =
                Mac.getInstance("HmacSHA256");

        SecretKeySpec secretKey =
                new SecretKeySpec(
                        SECRET_KEY.getBytes(StandardCharsets.UTF_8),
                        "HmacSHA256"
                );

        sha256Hmac.init(secretKey);

        byte[] hash =
                sha256Hmac.doFinal(
                        data.getBytes(StandardCharsets.UTF_8)
                );

        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(hash);
    }
}