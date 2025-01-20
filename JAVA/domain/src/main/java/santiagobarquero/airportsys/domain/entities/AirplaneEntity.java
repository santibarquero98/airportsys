package santiagobarquero.airportsys.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "tb_airplanes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String code;

    @Column
    private String name;

    @Column(name = "max_passengers")
    private Integer maxPassengers;

    @Column(name = "year_of_construction")
    private Integer yearOfConstruction;

}
