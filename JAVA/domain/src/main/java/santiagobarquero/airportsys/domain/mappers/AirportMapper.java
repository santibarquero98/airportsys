package santiagobarquero.airportsys.domain.mappers;

import org.mapstruct.Mapper;
import santiagobarquero.airportsys.domain.entities.AirportEntity;
import santiagobarquero.airportsys.domain.model.Airport;

@Mapper(componentModel = "spring")
public interface AirportMapper extends SuperMapper<Airport, AirportEntity> {
}
