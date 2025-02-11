package santiagobarquero.airportsys.application.service;

import jdk.jshell.spi.ExecutionControl;
import santiagobarquero.airportsys.domain.model.Passenger;
import santiagobarquero.airportsys.domain.model.data.DataPassenger;

public interface PassengerService {

    Passenger getById(Long id, Boolean loadData) throws ExecutionControl.NotImplementedException;

    void create(Passenger passenger);

    void assignFlight(String nif, String flightCode);

    Passenger findByNif(String nif);

    DataPassenger getAll();
}
