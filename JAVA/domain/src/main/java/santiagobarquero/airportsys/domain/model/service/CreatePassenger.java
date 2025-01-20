package santiagobarquero.airportsys.domain.model.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePassenger {

    private String name;

    private String surname;

    private String nif;

    private String country;

    private LocalDate birthday;
}
