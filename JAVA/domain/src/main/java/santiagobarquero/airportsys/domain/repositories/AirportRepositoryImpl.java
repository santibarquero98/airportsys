package santiagobarquero.airportsys.domain.repositories;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import santiagobarquero.airportsys.domain.entities.AirportEntity;
import santiagobarquero.airportsys.domain.repositories.jpa.AirportJpaRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AirportRepositoryImpl implements AirportRepository {

    private final AirportJpaRepository airportJpaRepository;

    @Override
    public AirportEntity findById(Long id) {
        return airportJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void save(AirportEntity airportEntity, Boolean flush) {
        airportJpaRepository.save(airportEntity);
        if(flush) airportJpaRepository.flush();
    }

    @Override
    public List<AirportEntity> findAll(Sort sort) {
        return airportJpaRepository.findAll(sort);
    }

    @Override
    public AirportEntity findByCode(String code) {
        return airportJpaRepository.findFirstByCode(code).orElseThrow(EntityNotFoundException::new);
    }
}
