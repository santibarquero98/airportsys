package santiagobarquero.airportsys.application.utils;


import java.util.Random;

public final class CodeUtils {

    private CodeUtils() {
        super();
    }

    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int CODE_SIZE = 2;
    private static final int NUMBER_LIMIT = 10000; // Rango de 0000 a 9999

    public static String getRandomCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder(CODE_SIZE + 4);
        for (int i = 0; i < CODE_SIZE; i++) {
            code.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
        }
        return code.append(String.format("%04d", random.nextInt(NUMBER_LIMIT))).toString();
    }

}
