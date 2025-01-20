package santiagobarquero.airportsys.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import santiagobarquero.airportsys.domain.entities.PassengerEntity;
import santiagobarquero.airportsys.domain.model.Passenger;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {

    Optional<PassengerEntity> findFirstByNif(String nif);

}
