package santiagobarquero.airportsys.domain.repositories.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import santiagobarquero.airportsys.domain.entities.PassengerEntity;

@Repository
public interface PassengerJpaRepository extends JpaRepository<PassengerEntity, Long> {

	Optional<PassengerEntity> findFirstByNif(String nif);

	Boolean existsByNif(String nif);

}
