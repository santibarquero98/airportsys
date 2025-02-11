package santiagobarquero.airportsys.domain.repositories;

import java.util.List;

import santiagobarquero.airportsys.domain.entities.FlightEntity;

public interface FlightRepository {

	FlightEntity findFirstByCode(String susceptFlightCode);

	FlightEntity save(FlightEntity flightEntity);

	FlightEntity findById(Long nFlight);

	List<FlightEntity> findAll();

}
