package santiagobarquero.airportsys.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "tb_airports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String code;

    @Column
    private String name;

    @Column
    private String city;

}
