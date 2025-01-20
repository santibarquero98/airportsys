package santiagobarquero.airportsys.application.service.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import santiagobarquero.airportsys.application.exceptions.TechnicalException;
import santiagobarquero.airportsys.application.service.AirplaneService;
import santiagobarquero.airportsys.application.service.AirportService;
import santiagobarquero.airportsys.application.service.FlightService;
import santiagobarquero.airportsys.domain.entities.AirplaneEntity;
import santiagobarquero.airportsys.domain.entities.AirportEntity;
import santiagobarquero.airportsys.domain.entities.FlightEntity;
import santiagobarquero.airportsys.domain.mappers.FlightMapper;
import santiagobarquero.airportsys.domain.model.Flight;
import santiagobarquero.airportsys.domain.model.service.CreateFlight;
import santiagobarquero.airportsys.domain.repositories.FlightRepository;

import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static santiagobarquero.airportsys.application.utils.CodeUtils.getRandomCode;

@Service
@AllArgsConstructor
public class FlightServiceAdapter implements FlightService {

    private final FlightRepository flightRepository;

    private final AirportService airportService;
    private final AirplaneService airplaneService;

    private final FlightMapper flightMapper;

    @Override
    public void create(CreateFlight createFlight) {
        AirportEntity origin = airportService.findByCode(createFlight.getAirportOriginCode()).orElseThrow(() -> new TechnicalException(getClass()));
        AirportEntity destination = airportService.findByCode(createFlight.getAiportDestinationCode()).orElseThrow(() -> new TechnicalException(getClass()));

        AirplaneEntity airplane = airplaneService.findByCode(createFlight.getAirplaneCode())
                .orElseThrow(() -> new TechnicalException(getClass()));

        String susceptFlightCode = null;
        Optional<FlightEntity> susceptExistingFlight;
        do {
            susceptFlightCode = generateFlightCode(origin.getCode(), destination.getCode());
            susceptExistingFlight = flightRepository.findFirstByCode(susceptFlightCode);
        } while (susceptExistingFlight.isEmpty());

        flightRepository.save(FlightEntity.builder()
                .code(susceptFlightCode)
                .boardingTime(createFlight.getBoardingTime())
                .origin(origin)
                .destination(destination)
                .airplane(airplane)
                .takeOffTime(createFlight.getTakeOffTime())
                .build());
    }

    @Override
    public Optional<FlightEntity> findById(Long nFlight) {
        return flightRepository.findById(nFlight);
    }

    @Override
    public List<Flight> getAll() {
        return flightMapper.toModelList(flightRepository.findAll());
    }

    @Override
    public Optional<FlightEntity> findByFlightCode(String flightCode) {
        return flightRepository.findFirstByCode(flightCode);
    }

    /* PRIVATE METHODS */

    private static String generateFlightCode(String origin, String destination) {
        return String.format("%s%s%s-%s", origin, destination, Year.now().getValue(), getRandomCode());
    }

}
