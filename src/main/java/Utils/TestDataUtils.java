package Utils;

import java.util.Random;

public class TestDataUtils {

    private static final String EMAIL_PREFIX = "test";
    private static final String EMAIL_DOMAIN = "@gmail.com";
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final Random random = new Random();

    public static String generateRandomEmail() {
        // generate 6 random letters
        StringBuilder letters = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            letters.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
        }

        // generate 3 random digits
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            digits.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }

        return EMAIL_PREFIX + letters + digits + EMAIL_DOMAIN;
    }

    public static String generateRandomUsername() {
        return "user" + System.currentTimeMillis(); // or use random letters/digits
    }

    public static String generateRandomPassword() {
        return "str" + random.nextInt(1000) + "gpvn" + random.nextInt(1000);
    }
}