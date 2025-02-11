package santiagobarquero.airportsys.application.utils;

import java.util.Random;

public final class CodeUtils {

	private static final Random RANDOM = new Random();

	private CodeUtils() {
		super();
	}

	private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int CODE_SIZE = 2;
	private static final int NUMBER_LIMIT = 10000;

	public static String getRandomCode() {
		StringBuilder code = new StringBuilder(CODE_SIZE + 4);
		for (int i = 0; i < CODE_SIZE; i++) {
			code.append(LETTERS.charAt(RANDOM.nextInt(LETTERS.length())));
		}
		return code.append(String.format("%04d", RANDOM.nextInt(NUMBER_LIMIT))).toString();
	}

}
