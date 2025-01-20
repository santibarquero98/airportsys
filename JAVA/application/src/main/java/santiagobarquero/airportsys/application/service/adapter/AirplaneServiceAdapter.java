package santiagobarquero.airportsys.application.service.adapter;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import santiagobarquero.airportsys.application.service.AirplaneService;
import santiagobarquero.airportsys.application.utils.CodeUtils;
import santiagobarquero.airportsys.domain.entities.AirplaneEntity;
import santiagobarquero.airportsys.domain.mappers.AirplaneMapper;
import santiagobarquero.airportsys.domain.model.Airplane;
import santiagobarquero.airportsys.domain.model.service.CreateAirplane;
import santiagobarquero.airportsys.domain.repositories.AirplaneRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AirplaneServiceAdapter implements AirplaneService {

    private final AirplaneRepository airplaneRepository;

    private final AirplaneMapper airplaneMapper;

    @Override
    public AirplaneEntity findById(Long airplane) {
        return airplaneRepository.findById(airplane).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void create(CreateAirplane createAirplane) {
        Integer yearOfConstruction = createAirplane.getYearOfConstruction();
        String name = createAirplane.getName();
        airplaneRepository.save(AirplaneEntity.builder()
                .code(String.format("%s%s-%s",
                        yearOfConstruction,
                        name.substring(0, 3).toUpperCase(),
                        CodeUtils.getRandomCode()))
                .name(name)
                .yearOfConstruction(yearOfConstruction)
                .maxPassengers(createAirplane.getMaxPassengers())
                .build());
    }

    @Override
    public List<Airplane> getAll() {
        return airplaneMapper.toModelList(airplaneRepository.findAll());
    }

    @Override
    public Optional<AirplaneEntity> findByCode(String airplaneCode) {
        return airplaneRepository.findFirstByCode(airplaneCode);
    }
}
