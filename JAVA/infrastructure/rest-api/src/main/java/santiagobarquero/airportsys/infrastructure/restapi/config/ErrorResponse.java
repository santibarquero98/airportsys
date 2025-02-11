package santiagobarquero.airportsys.infrastructure.restapi.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ErrorResponse {

	private final Integer statusCode;
	private final Integer httpStatus;
	private final String message;
	
}
