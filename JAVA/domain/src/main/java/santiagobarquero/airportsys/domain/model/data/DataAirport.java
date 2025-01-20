package santiagobarquero.airportsys.domain.model.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import santiagobarquero.airportsys.domain.model.Airport;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class DataAirport {

    private final List<Airport> data;

}
