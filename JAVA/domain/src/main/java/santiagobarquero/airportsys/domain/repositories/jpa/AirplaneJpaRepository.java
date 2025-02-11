package santiagobarquero.airportsys.domain.repositories.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import santiagobarquero.airportsys.domain.entities.AirplaneEntity;

@Repository
public interface AirplaneJpaRepository extends JpaRepository<AirplaneEntity, Long> {

    @Query("select ae from AirplaneEntity ae where ae.code = :code")
    Optional<AirplaneEntity> findByCode(@Param("code") String code);

}
