package santiagobarquero.airportsys.domain.model.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import santiagobarquero.airportsys.domain.model.Flight;
import santiagobarquero.airportsys.domain.model.Passenger;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class DataFlight implements Serializable {

    private final List<Flight> data;

}
