package santiagobarquero.airportsys.application.service.adapter;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import santiagobarquero.airportsys.application.exceptions.ExceptionMessagesHelper;
import santiagobarquero.airportsys.application.service.PassengerService;
import santiagobarquero.airportsys.domain.entities.FlightEntity;
import santiagobarquero.airportsys.domain.entities.PassengerEntity;
import santiagobarquero.airportsys.domain.mappers.PassengerMapper;
import santiagobarquero.airportsys.domain.model.Passenger;
import santiagobarquero.airportsys.domain.model.data.DataPassenger;
import santiagobarquero.airportsys.domain.repositories.PassengerRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PassengerServiceAdapter implements PassengerService {

    private final PassengerRepository passengerRepository;

    private final PassengerMapper passengerMapper;

    @Override
    public PassengerEntity getById(Long id) {
        return passengerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void create(Passenger passenger) {
        PassengerEntity passengerEntity = PassengerEntity.builder()
                .nif(passenger.getNif())
                .name(passenger.getName())
                .surname(passenger.getSurname())
                .birthday(passenger.getBirthday())
                .country(passenger.getCountry())
                .build();
        passengerRepository.save(passengerEntity);
    }

    @Override
    public void assignFlight(String nif, FlightEntity flight) {
        PassengerEntity passengerEntity = findByNif(nif).orElseThrow(() -> new EntityNotFoundException(ExceptionMessagesHelper.getEntityNotFoundExceptionMsg("PassengerEntity")));
        List<FlightEntity> passengersList = passengerEntity.getFlights();
        passengersList.add(flight);
        passengerRepository.save(passengerEntity);
    }

    @Override
    public Optional<PassengerEntity> findByNif(String nif) {
        return passengerRepository.findFirstByNif(nif);
    }

    @Override
    public DataPassenger getAll() {
        return DataPassenger.builder().data(passengerMapper.toModelList(passengerRepository.findAll())).build();
    }

    private Optional<PassengerEntity> findById(Long nPassenger) {
        return passengerRepository.findById(nPassenger);
    }

}
