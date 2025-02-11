package santiagobarquero.airportsys.domain.repositories;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import santiagobarquero.airportsys.domain.entities.FlightEntity;
import santiagobarquero.airportsys.domain.repositories.jpa.FlightJpaRepository;

@Repository
@AllArgsConstructor
public class FlightRepositoryImpl implements FlightRepository {

	private final FlightJpaRepository flightJpaRepository;

	@Override
	public FlightEntity findFirstByCode(String flightCode) {
		FlightEntity flightEntity = flightJpaRepository.findFirstByCode(flightCode);
		if (Objects.isNull(flightEntity)) throw new EntityNotFoundException("FlightEntity");
		return flightEntity;
	}

	@Override
	public FlightEntity save(FlightEntity flightEntity) {
		return flightJpaRepository.save(flightEntity);

	}

	@Override
	public FlightEntity findById(Long id) {
		return flightJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<FlightEntity> findAll() {
		return flightJpaRepository.findAll();
	}

}
