package santiagobarquero.airportsys.application.service;

import santiagobarquero.airportsys.domain.entities.AirportEntity;
import santiagobarquero.airportsys.domain.model.Airport;
import santiagobarquero.airportsys.domain.model.data.DataAirport;
import santiagobarquero.airportsys.domain.model.service.CreateAirport;

import java.util.List;
import java.util.Optional;

public interface AirportService {

    AirportEntity findById(Long destination);

    void create(CreateAirport createAirport);

    List<Airport> getAll();

    Optional<AirportEntity> findByCode(String code);
}
