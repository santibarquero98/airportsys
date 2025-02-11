package santiagobarquero.airportsys.application.service.adapter;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import jdk.jshell.spi.ExecutionControl;
import lombok.AllArgsConstructor;
import santiagobarquero.airportsys.application.exceptions.TechnicalException;
import santiagobarquero.airportsys.application.service.PassengerService;
import santiagobarquero.airportsys.domain.entities.FlightEntity;
import santiagobarquero.airportsys.domain.entities.PassengerEntity;
import santiagobarquero.airportsys.domain.enums.TypeNifEnum;
import santiagobarquero.airportsys.domain.mappers.PassengerMapper;
import santiagobarquero.airportsys.domain.model.Passenger;
import santiagobarquero.airportsys.domain.model.data.DataPassenger;
import santiagobarquero.airportsys.domain.repositories.FlightRepository;
import santiagobarquero.airportsys.domain.repositories.PassengerRepository;

@Service
@AllArgsConstructor
public class PassengerServiceAdapter implements PassengerService {

	private final PassengerRepository passengerRepository;

	private final PassengerMapper passengerMapper;

	private final FlightRepository flightRepository;

	@Override
	public Passenger getById(Long id, Boolean loadData) throws ExecutionControl.NotImplementedException {
		if (loadData) {
			throw new ExecutionControl.NotImplementedException(
					"Method PassengerServiceAdapter.getById not implemented.");
		} else {
			return passengerMapper.toModel(passengerRepository.findById(id));
		}
	}

	@Override
	public void create(Passenger passenger) {

		TypeNifEnum typeNifEnum = TypeNifEnum.valueOf(passenger.getTypeNif());

		String nif = passenger.getNif();

		if (passengerRepository.existsByNif(nif)) {
			throw new TechnicalException(getClass(), String.format("NIF '%s' already exists in database", nif), null,
					null, null);
		}

		if (!NIFUtils.isValidDniOrNif(nif))
			throw new TechnicalException(getClass(),
					String.format("Nif '%s' is not a valid for type '%s'", nif, typeNifEnum.name()), null, null, null);

		PassengerEntity passengerEntity = PassengerEntity.builder().nif(nif).typeNif(typeNifEnum)
				.name(passenger.getName()).surname(passenger.getSurname()).birthday(passenger.getBirthday())
				.country(passenger.getCountry()).signUpDate(LocalDateTime.now()).build();
		passengerRepository.save(passengerEntity, Boolean.FALSE);
	}

	@Override
	public void assignFlight(String nif, String flightCode) {
		FlightEntity flight = flightRepository.findFirstByCode(flightCode);
		PassengerEntity passenger = passengerRepository.findByNif(nif);
		List<FlightEntity> flightsList = passenger.getFlights();
		flightsList.add(flight);
		passengerRepository.save(passenger, Boolean.FALSE);
	}

	@Override
	public Passenger findByNif(String nif) {
		return passengerMapper.toModel(passengerRepository.findByNif(nif));
	}

	@Override
	public DataPassenger getAll() {
		return DataPassenger.builder().data(passengerMapper.toModelList(passengerRepository.findAll(null))).build();
	}

}
