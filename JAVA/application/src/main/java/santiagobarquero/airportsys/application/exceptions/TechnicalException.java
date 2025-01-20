package santiagobarquero.airportsys.application.exceptions;

import lombok.Getter;

@Getter
public class TechnicalException extends RuntimeException {

    private final Class<?> originalClass;

    private static final String GENERIC_TECHNICAL_EXCEPTION = "Consultation with the maintenance team.";

    public TechnicalException(Class<?> originalClass) {
        super(GENERIC_TECHNICAL_EXCEPTION);
        this.originalClass = originalClass;
    }

    public TechnicalException(String msg, Class<?> originalClass) {
        super(msg);
        this.originalClass = originalClass;
    }

}
