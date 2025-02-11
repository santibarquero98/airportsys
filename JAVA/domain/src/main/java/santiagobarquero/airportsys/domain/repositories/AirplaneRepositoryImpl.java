package santiagobarquero.airportsys.domain.repositories;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import santiagobarquero.airportsys.domain.entities.AirplaneEntity;
import santiagobarquero.airportsys.domain.repositories.jpa.AirplaneJpaRepository;

import java.util.List;
import java.util.Objects;

@Repository
@AllArgsConstructor
public class AirplaneRepositoryImpl implements AirplaneRepository {

    private final AirplaneJpaRepository airplaneJpaRepository;

    @Override
    public AirplaneEntity findById(Long airplane) {
        return airplaneJpaRepository.findById(airplane).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void save(AirplaneEntity airplaneEntity, Boolean flush) {
        airplaneJpaRepository.save(airplaneEntity);
        if (flush) airplaneJpaRepository.flush();
    }

    @Override
    public List<AirplaneEntity> findAll(Sort sort) {
        if(Objects.isNull(sort)) throw new IllegalArgumentException("Argument 'sort' cannot be null");
        return airplaneJpaRepository.findAll(sort);
    }

    @Override
    public AirplaneEntity findByCode(String airplaneCode) {
        return airplaneJpaRepository.findByCode(airplaneCode).orElseThrow(EntityNotFoundException::new);
    }
}
