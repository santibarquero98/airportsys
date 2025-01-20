package santiagobarquero.airportsys.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import santiagobarquero.airportsys.domain.entities.AirportEntity;
import santiagobarquero.airportsys.domain.model.Airport;

import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, Long> {

    Optional<AirportEntity> findFirstByCode(String code);

}
