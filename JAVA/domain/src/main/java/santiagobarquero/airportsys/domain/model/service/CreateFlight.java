package santiagobarquero.airportsys.domain.model.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateFlight {

    private String airplaneCode;

    private String airportOriginCode;

    private String aiportDestinationCode;

    private LocalDateTime boardingTime;

    private LocalDateTime takeOffTime;

}
