package santiagobarquero.airportsys.application.service;

import santiagobarquero.airportsys.domain.entities.AirplaneEntity;
import santiagobarquero.airportsys.domain.model.Airplane;
import santiagobarquero.airportsys.domain.model.service.CreateAirplane;

import java.util.List;
import java.util.Optional;

public interface AirplaneService {

    AirplaneEntity findById(Long airplane);

    void create(CreateAirplane createAirplane);

    List<Airplane> getAll();

    Optional<AirplaneEntity> findByCode(String airplaneCode);
}
