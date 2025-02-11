package santiagobarquero.airportsys.domain.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;

import santiagobarquero.airportsys.domain.entities.PassengerEntity;

public interface PassengerRepository {

    PassengerEntity findByNif(String nif);

    PassengerEntity findById(Long id);

    void save(PassengerEntity passengerEntity, boolean flush);

    List<PassengerEntity> findAll(Sort sort);

	Boolean existsByNif(String nif);
}
