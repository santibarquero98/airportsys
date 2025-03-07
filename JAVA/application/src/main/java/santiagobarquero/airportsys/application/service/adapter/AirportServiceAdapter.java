package santiagobarquero.airportsys.application.service.adapter;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import santiagobarquero.airportsys.application.service.AirportService;
import santiagobarquero.airportsys.domain.entities.AirportEntity;
import santiagobarquero.airportsys.domain.mappers.AirportMapper;
import santiagobarquero.airportsys.domain.model.Airport;
import santiagobarquero.airportsys.domain.model.service.CreateAirport;
import santiagobarquero.airportsys.domain.repositories.AirportRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AirportServiceAdapter implements AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    @Override
    public Airport findById(Long id) {
        return airportMapper.toModel(airportRepository.findById(id));
    }

    @Override
    public void create(CreateAirport createAirport) {
        AirportEntity airport = AirportEntity.builder()
                .code(generateAirportCode(createAirport.getName()))
                .city(createAirport.getCity())
                .name(createAirport.getName())
                .build();

        airportRepository.save(airport, Boolean.FALSE);
    }

    @Override
    public List<Airport> getAll() {
        return airportMapper.toModelList(airportRepository.findAll(Sort.unsorted()));
    }

    @Override
    public Airport findByCode(String code) {
        return airportMapper.toModel(airportRepository.findByCode(code));
    }

    /* PRIVATE METHODS */

    private static String generateAirportCode(String name) {
        return String.format("%s", name.substring(0, 3));
    }
}
