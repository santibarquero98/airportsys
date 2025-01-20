package santiagobarquero.airportsys.domain.mappers;

import org.mapstruct.Mapper;
import santiagobarquero.airportsys.domain.entities.AirplaneEntity;
import santiagobarquero.airportsys.domain.model.Airplane;

@Mapper(componentModel = "spring")
public interface AirplaneMapper extends SuperMapper<Airplane, AirplaneEntity> {
}
