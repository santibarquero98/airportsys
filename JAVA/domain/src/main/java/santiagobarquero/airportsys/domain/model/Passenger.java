package santiagobarquero.airportsys.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passenger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String surname;

	private String typeNif;
	
	private String nif;

	private String country;

	private LocalDate birthday;

	private List<Flight> flights;

}
