package santiagobarquero.airportsys.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import santiagobarquero.airportsys.domain.entities.AirplaneEntity;
import santiagobarquero.airportsys.domain.model.Airplane;

import java.util.Optional;

@Repository
public interface AirplaneRepository extends JpaRepository<AirplaneEntity, Long> {

    @Query("select ae from AirplaneEntity ae where ae.code = :code")
    Optional<AirplaneEntity> findFirstByCode(@Param("code") String code);

}
