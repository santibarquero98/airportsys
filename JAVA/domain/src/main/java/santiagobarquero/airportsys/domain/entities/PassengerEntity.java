package santiagobarquero.airportsys.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Entity
@Table(name = "tb_passengers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String nif;

    @Column
    private String country;

    @Column
    private LocalDate birthday;

    @ManyToMany
    @JoinTable(
            name = "passenger_flight",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id")
    )
    private List<FlightEntity> flights;

}
