package santiagobarquero.airportsys.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Airport {

    private Long id;

    private final String name;

    private final String city;

}
