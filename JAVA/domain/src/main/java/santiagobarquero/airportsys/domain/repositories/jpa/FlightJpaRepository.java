package santiagobarquero.airportsys.domain.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import santiagobarquero.airportsys.domain.entities.FlightEntity;

/**
 * @author santi
 * The class only must be inyected on a FlightRepository interface
 */
@Repository
public interface FlightJpaRepository extends JpaRepository<FlightEntity, Long> {

    @Query("select fe from FlightEntity fe where fe.code = :code")
    FlightEntity findFirstByCode(@Param("code") String flightCode);

}
