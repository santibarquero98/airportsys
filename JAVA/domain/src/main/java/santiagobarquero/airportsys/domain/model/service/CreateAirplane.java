package santiagobarquero.airportsys.domain.model.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAirplane implements Serializable {

    private String name;

    private Integer maxPassengers;

    private Integer yearOfConstruction;

}
