package santiagobarquero.airportsys.application.service;

import java.util.List;

import santiagobarquero.airportsys.domain.model.Flight;
import santiagobarquero.airportsys.domain.model.service.CreateFlight;

public interface FlightService {

    void create(CreateFlight createFlight);

    Flight findById(Long nFlight);

    List<Flight> getAll();

    Flight findByFlightCode(String flightCode);

	void markOnFly(String flightCode);

	void setLand(String flightCode);
}
