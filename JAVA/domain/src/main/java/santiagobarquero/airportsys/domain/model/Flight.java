package santiagobarquero.airportsys.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Flight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String code;
	private final Airplane airplane;
	private final Airport origin;
	private final Airport destination;
	private final List<Passenger> passengers;
	private final LocalDateTime boardingTime;
	private final LocalDateTime takeOffTime;
	private final LocalDateTime landedTime;
	private final Boolean finalized;
	private final Boolean onFly;

}
