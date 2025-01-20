package santiagobarquero.airportsys.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Flight {

    private Long id;

    private String code;

    private final Airplane airplane;

    private final Airport origin;

    private final Airport destination;

    private final List<Passenger> passengers;

    private final LocalDateTime boardingTime;

    private final LocalDateTime takeOffTime;

}
