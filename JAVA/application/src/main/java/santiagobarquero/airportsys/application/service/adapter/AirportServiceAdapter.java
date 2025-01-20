package santiagobarquero.airportsys.application.service.adapter;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import santiagobarquero.airportsys.application.service.AirportService;
import santiagobarquero.airportsys.domain.entities.AirportEntity;
import santiagobarquero.airportsys.domain.mappers.AirportMapper;
import santiagobarquero.airportsys.domain.model.Airport;
import santiagobarquero.airportsys.domain.model.service.CreateAirport;
import santiagobarquero.airportsys.domain.repositories.AirportRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AirportServiceAdapter implements AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    @Override
    public AirportEntity findById(Long airport) {
        return airportRepository.findById(airport).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void create(CreateAirport createAirport) {
        AirportEntity airport = AirportEntity.builder()
                .code(generateAirportCode(createAirport.getName()))
                .city(createAirport.getCity())
                .name(createAirport.getName())
                .build();

        airportRepository.save(airport);
    }

    @Override
    public List<Airport> getAll() {
        return airportMapper.toModelList(airportRepository.findAll());
    }

    @Override
    public Optional<AirportEntity> findByCode(String code) {
        return airportRepository.findFirstByCode(code);
    }

    /* PRIVATE METHODS */

    private static String generateAirportCode(String name) {
        return String.format("%s", name.substring(0, 3));
    }
}
