package santiagobarquero.airportsys.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import santiagobarquero.airportsys.domain.entities.FlightEntity;

import java.util.Optional;

/**
 * @author santi
 * The class only must be inyected on a FlightService interface
 */
@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

    @Query("select fe from FlightEntity fe where fe.code = :code")
    Optional<FlightEntity> findFirstByCode(@Param("code") String flightCode);

}
