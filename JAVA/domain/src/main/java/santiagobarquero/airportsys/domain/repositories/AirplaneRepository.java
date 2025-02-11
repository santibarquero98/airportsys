package santiagobarquero.airportsys.domain.repositories;

import org.springframework.data.domain.Sort;
import santiagobarquero.airportsys.domain.entities.AirplaneEntity;

import java.util.List;

public interface AirplaneRepository {

    AirplaneEntity findById(Long airplane);

    void save(AirplaneEntity build, Boolean aFalse);

    List<AirplaneEntity> findAll(Sort sort);

    AirplaneEntity findByCode(String airplaneCode);
}
