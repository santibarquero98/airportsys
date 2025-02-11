package santiagobarquero.airportsys.application.service;

import java.util.List;

import santiagobarquero.airportsys.domain.model.Airplane;
import santiagobarquero.airportsys.domain.model.service.CreateAirplane;

public interface AirplaneService {

    Airplane findById(Long airplane);

    void create(CreateAirplane createAirplane);

    List<Airplane> getAll();

    Airplane findByCode(String airplaneCode);
}
