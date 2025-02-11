package santiagobarquero.airportsys.domain.repositories.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import santiagobarquero.airportsys.domain.entities.AirportEntity;

@Repository
public interface AirportJpaRepository extends JpaRepository<AirportEntity, Long> {

	Optional<AirportEntity> findFirstByCode(String code);

}
