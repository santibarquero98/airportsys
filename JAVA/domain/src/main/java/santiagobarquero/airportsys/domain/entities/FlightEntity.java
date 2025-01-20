package santiagobarquero.airportsys.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@Table(name = "tb_flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "airplane_id", nullable = false)
    private AirplaneEntity airplane;

    @ManyToOne
    @JoinColumn(name = "origin_id", nullable = false)
    private AirportEntity origin;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private AirportEntity destination;

    @Column(name = "boardingTime")
    private LocalDateTime boardingTime;

    @Column(name = "takeOffTime")
    private LocalDateTime takeOffTime;

    @ManyToMany(mappedBy = "flights", cascade = CascadeType.ALL)
    private List<PassengerEntity> passengers;

}
