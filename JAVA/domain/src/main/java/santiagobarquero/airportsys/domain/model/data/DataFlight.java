package santiagobarquero.airportsys.domain.model.data;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import santiagobarquero.airportsys.domain.model.Flight;

@AllArgsConstructor
@Builder
@Data
public class DataFlight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final List<Flight> data;

}
