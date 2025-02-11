package santiagobarquero.airportsys.domain.model.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import santiagobarquero.airportsys.domain.model.Airplane;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class DataAirplane implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final List<Airplane> data;

}
