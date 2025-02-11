package santiagobarquero.airportsys.config;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import santiagobarquero.airportsys.application.exceptions.TechnicalException;
import santiagobarquero.airportsys.infrastructure.restapi.config.ErrorResponse;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	private static final String GENERIC_TECHNICAL_EXCEPTION = "Consultation with the maintenance team.";

	@ExceptionHandler(TechnicalException.class)
	public ResponseEntity<ErrorResponse> handleTechnicalException(TechnicalException ex) {
		String errorMessage = ex.getMessage();
		if (StringUtils.isBlank(errorMessage))
			errorMessage = GENERIC_TECHNICAL_EXCEPTION;

		Integer httpStatusInt = ex.getHttpStatus();
		HttpStatus httpStatus = Objects.isNull(httpStatusInt) ? HttpStatus.INTERNAL_SERVER_ERROR
				: HttpStatus.valueOf(httpStatusInt);

		ErrorResponse errorResponse = ErrorResponse.builder().statusCode(ex.getErrorCode()).message(errorMessage)
				.httpStatus(httpStatus.value()).build();
		log.error(ex.getMessage());
		return new ResponseEntity<>(errorResponse, httpStatus);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		String message = String.format("Entity with name '%s' does not exists", ex.getMessage());
		ErrorResponse errorResponse = ErrorResponse.builder().statusCode(null)
				.message(message)
				.httpStatus(httpStatus.value()).build();
		log.error(message, ex);
		return new ResponseEntity<>(errorResponse, httpStatus);
	}
}