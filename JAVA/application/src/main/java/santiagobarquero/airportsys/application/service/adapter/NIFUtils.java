package santiagobarquero.airportsys.application.service.adapter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NIFUtils {
	
	private NIFUtils() {
		super();
	}

	private static final String NIF_REGEX = "^(?:[XYZ]?\\d{7,8}[A-Z]|[A-HJ-NP-SUVW]\\d{7,8}[A-JZ])$";

	public static Boolean isValidDniOrNif(String dniOrNif) {
		Pattern pattern = Pattern.compile(NIF_REGEX);
		Matcher matcher = pattern.matcher(dniOrNif);

		if (!matcher.matches())
			return Boolean.FALSE;

		if (dniOrNif.length() == 9 && dniOrNif.charAt(8) >= 'A' && dniOrNif.charAt(8) <= 'Z')
			return isValidDni(dniOrNif);

		return Boolean.TRUE;
	}

	private static boolean isValidDni(String dni) {
		String dniNumbers = dni.substring(0, 8);
		char dniLetter = dni.charAt(8);
		String validLetters = "TRWAGMYFPDXBNJZSQVHLCKE".substring(Integer.parseInt(dniNumbers) % 23,
				Integer.parseInt(dniNumbers) % 23 + 1);

		return validLetters.charAt(0) == dniLetter;
	}

}
