package santiagobarquero.airportsys.domain.mappers;

import org.mapstruct.Mapper;
import santiagobarquero.airportsys.domain.entities.FlightEntity;
import santiagobarquero.airportsys.domain.entities.PassengerEntity;
import santiagobarquero.airportsys.domain.model.Flight;
import santiagobarquero.airportsys.domain.model.Passenger;

@Mapper(componentModel = "spring")
public interface FlightMapper extends SuperMapper<Flight, FlightEntity> {
}
