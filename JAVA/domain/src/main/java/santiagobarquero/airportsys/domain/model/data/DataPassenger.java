package santiagobarquero.airportsys.domain.model.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import santiagobarquero.airportsys.domain.model.Passenger;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class DataPassenger implements Serializable {

    private final List<Passenger> data;

}
