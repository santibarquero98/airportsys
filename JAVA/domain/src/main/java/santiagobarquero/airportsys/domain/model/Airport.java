package santiagobarquero.airportsys.domain.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Airport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9184477744729055658L;
	private Long id;
	private String code;
	private String name;
	private String city;
}
