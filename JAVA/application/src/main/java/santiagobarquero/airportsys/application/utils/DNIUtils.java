package santiagobarquero.airportsys.application.utils;

import java.util.Objects;

public final class DNIUtils {

	private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

	private DNIUtils() {
		super();
	}

	public static Boolean validDni(String dni) {
		if (Objects.isNull(dni) || !dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
			return false;
		}
		int numero = Integer.parseInt(dni.substring(0, 8));
		char letraCalculada = LETRAS_DNI.charAt(numero % 23);
		char letraIngresada = dni.charAt(8);
		return letraCalculada == letraIngresada;
	}

	public static Boolean validNie(String nie) {
		if (Objects.isNull(nie) || !nie.matches("[XYZ]\\d{7}[A-HJ-NP-TV-Z]")) {
			return false;
		}
		char firstLetter = nie.charAt(0);
		String nieNumber = switch (firstLetter) {
		case 'X' -> "0" + nie.substring(1, 8);
		case 'Y' -> "1" + nie.substring(1, 8);
		case 'Z' -> "2" + nie.substring(1, 8);
		default -> throw new IllegalArgumentException("First letter of NIE is invalid");
		};
		return validDni(nieNumber + nie.charAt(8));
	}

}
