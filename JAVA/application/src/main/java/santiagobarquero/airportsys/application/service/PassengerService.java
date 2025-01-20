package santiagobarquero.airportsys.application.service;

import santiagobarquero.airportsys.domain.entities.FlightEntity;
import santiagobarquero.airportsys.domain.entities.PassengerEntity;
import santiagobarquero.airportsys.domain.model.Passenger;
import santiagobarquero.airportsys.domain.model.data.DataPassenger;

import java.util.Optional;

public interface PassengerService {

    PassengerEntity getById(Long p);

    void create(Passenger passenger);

    void assignFlight(String nPassenger, FlightEntity flight);

    Optional<PassengerEntity> findByNif(String nif);

    DataPassenger getAll();
}
