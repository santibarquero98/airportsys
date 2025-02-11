package santiagobarquero.airportsys.domain.mappers;

import org.mapstruct.Mapper;

import santiagobarquero.airportsys.domain.entities.PassengerEntity;
import santiagobarquero.airportsys.domain.model.Passenger;

@Mapper(componentModel = "spring")
public interface PassengerMapper extends SuperMapper<Passenger, PassengerEntity> {

}
