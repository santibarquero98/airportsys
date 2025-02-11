package santiagobarquero.airportsys.application.service.adapter;

import static santiagobarquero.airportsys.application.utils.CodeUtils.getRandomCode;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import santiagobarquero.airportsys.application.service.AirplaneService;
import santiagobarquero.airportsys.application.service.AirportService;
import santiagobarquero.airportsys.application.service.FlightService;
import santiagobarquero.airportsys.domain.entities.FlightEntity;
import santiagobarquero.airportsys.domain.mappers.AirplaneMapper;
import santiagobarquero.airportsys.domain.mappers.AirportMapper;
import santiagobarquero.airportsys.domain.mappers.FlightMapper;
import santiagobarquero.airportsys.domain.model.Airplane;
import santiagobarquero.airportsys.domain.model.Airport;
import santiagobarquero.airportsys.domain.model.Flight;
import santiagobarquero.airportsys.domain.model.service.CreateFlight;
import santiagobarquero.airportsys.domain.repositories.FlightRepository;

@Service
@AllArgsConstructor
public class FlightServiceAdapter implements FlightService {

	/* Repository */
	private final FlightRepository flightRepository;

	/* External repositories */

	/* External Services */
	private final AirportService airportService;
	private final AirplaneService airplaneService;

	/* Mappers */
	private final FlightMapper flightMapper;
	private final AirportMapper airportMapper;
	private final AirplaneMapper airplaneMapper;

	@Override
	public void create(CreateFlight createFlight) {
		Airport origin = airportService.findByCode(createFlight.getAirportOriginCode());
		Airport destination = airportService.findByCode(createFlight.getAiportDestinationCode());

		Airplane airplane = airplaneService.findByCode(createFlight.getAirplaneCode());

		String susceptFlightCode = null;
		Flight susceptExistingFlight;
		do {
			susceptFlightCode = generateFlightCode(origin.getCode(), destination.getCode());
			susceptExistingFlight = flightMapper.toModel(flightRepository.findFirstByCode(susceptFlightCode));
		} while (Objects.nonNull(susceptExistingFlight));

		flightRepository.save(FlightEntity.builder().code(susceptFlightCode)
				.boardingTime(createFlight.getBoardingTime()).origin(airportMapper.toEntity(origin))
				.destination(airportMapper.toEntity(destination)).airplane(airplaneMapper.toEntity(airplane))
				.takeOffTime(createFlight.getTakeOffTime()).build());
	}

	@Override
	public Flight findById(Long nFlight) {
		return flightMapper.toModel(flightRepository.findById(nFlight));
	}

	@Override
	public List<Flight> getAll() {
		return flightMapper.toModelList(flightRepository.findAll());
	}

	@Override
	public Flight findByFlightCode(String flightCode) {
		return flightMapper.toModel(flightRepository.findFirstByCode(flightCode));
	}

	@Override
	public void markOnFly(String flightCode) {
		FlightEntity flightEntity = flightRepository.findFirstByCode(flightCode);
		flightEntity.setOnFly(Boolean.TRUE);
		flightRepository.save(flightEntity);
	}

	@Override
	public void setLand(String flightCode) {
		FlightEntity flightEntity = flightRepository.findFirstByCode(flightCode);
		flightEntity.setOnFly(Boolean.FALSE);
		flightEntity.setLandedTime(LocalDateTime.now());
		flightRepository.save(flightEntity);
	}

	/* PRIVATE METHODS */

	private static String generateFlightCode(String origin, String destination) {
		return String.format("%s%s%s-%s", origin, destination, Year.now().getValue(), getRandomCode());
	}

}
