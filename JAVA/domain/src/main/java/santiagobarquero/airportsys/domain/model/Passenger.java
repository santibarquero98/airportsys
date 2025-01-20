package santiagobarquero.airportsys.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passenger implements Serializable {

    private Long id;

    private String name;

    private String surname;

    private String nif;

    private String country;

    private LocalDate birthday;

}
