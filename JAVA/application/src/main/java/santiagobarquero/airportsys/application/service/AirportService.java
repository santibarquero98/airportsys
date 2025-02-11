package santiagobarquero.airportsys.application.service;

import santiagobarquero.airportsys.domain.model.Airport;
import santiagobarquero.airportsys.domain.model.service.CreateAirport;

import java.util.List;

public interface AirportService {

    Airport findById(Long destination);

    void create(CreateAirport createAirport);

    List<Airport> getAll();

    Airport findByCode(String code);
}
