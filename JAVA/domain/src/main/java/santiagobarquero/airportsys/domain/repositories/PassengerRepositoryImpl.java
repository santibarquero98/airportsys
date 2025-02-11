package santiagobarquero.airportsys.domain.repositories;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import santiagobarquero.airportsys.domain.entities.PassengerEntity;
import santiagobarquero.airportsys.domain.repositories.jpa.PassengerJpaRepository;

@Repository
@AllArgsConstructor
public class PassengerRepositoryImpl implements PassengerRepository {

    private final PassengerJpaRepository passengerJpaRepository;


    @Override
    public PassengerEntity findByNif(String nif) {
        return passengerJpaRepository.findFirstByNif(nif).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public PassengerEntity findById(Long id) {
        return passengerJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void save(PassengerEntity passengerEntity, boolean flush) {
        passengerJpaRepository.save(passengerEntity);
        if (flush) passengerJpaRepository.flush();
    }

    @Override
    public List<PassengerEntity> findAll(Sort sort) {
        if (Objects.isNull(sort)) sort = Sort.unsorted();
        return passengerJpaRepository.findAll(sort);
    }

	@Override
	public Boolean existsByNif(String nif) {
		return passengerJpaRepository.existsByNif(nif);
	}
}
