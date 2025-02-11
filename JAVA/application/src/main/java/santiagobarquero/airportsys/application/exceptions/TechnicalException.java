package santiagobarquero.airportsys.application.exceptions;

import java.util.Objects;

import lombok.Getter;

@Getter
public class TechnicalException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final Class<?> clazz;
	private final Exception originalException;
	private final Integer httpStatus;
	private final Integer errorCode;

	@Override
	public String getMessage() {
		String detailMessage = super.getMessage();
		if (Objects.nonNull(originalException)) {
			return detailMessage.concat("\n").concat(originalException.getMessage());
		}
		return detailMessage;
	}

	public TechnicalException(Class<?> clazz, String message, Exception originalException, Integer httpStatus,
			Integer errorCode) {
		super(message);
		this.clazz = clazz;
		this.originalException = originalException;
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
	}

}
