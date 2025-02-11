package santiagobarquero.airportsys.domain.model.service;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePassenger {

    private String name;

    private String surname;
    
    private String typeNif;

    private String nif;

    private String country;

    private LocalDate birthday;
}
