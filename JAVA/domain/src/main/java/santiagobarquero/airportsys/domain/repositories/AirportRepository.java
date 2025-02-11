package santiagobarquero.airportsys.domain.repositories;

import org.springframework.data.domain.Sort;
import santiagobarquero.airportsys.domain.entities.AirportEntity;

import java.util.List;

public interface AirportRepository {

    AirportEntity findById(Long id);

    void save(AirportEntity airport, Boolean aFalse);

    List<AirportEntity> findAll(Sort unsorted);

    AirportEntity findByCode(String code);
}
