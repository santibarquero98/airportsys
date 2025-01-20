package santiagobarquero.airportsys.application.service;

import santiagobarquero.airportsys.domain.entities.FlightEntity;
import santiagobarquero.airportsys.domain.model.Flight;
import santiagobarquero.airportsys.domain.model.data.DataFlight;
import santiagobarquero.airportsys.domain.model.service.CreateFlight;

import java.util.List;
import java.util.Optional;

public interface FlightService {

    void create(CreateFlight createFlight);

    Optional<FlightEntity> findById(Long nFlight);

    List<Flight> getAll();

    Optional<FlightEntity> findByFlightCode(String flightCode);
}
