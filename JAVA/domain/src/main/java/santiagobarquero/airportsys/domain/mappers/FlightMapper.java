package santiagobarquero.airportsys.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import santiagobarquero.airportsys.domain.entities.FlightEntity;
import santiagobarquero.airportsys.domain.model.Flight;

@Mapper(componentModel = "spring")
public interface FlightMapper extends SuperMapper<Flight, FlightEntity> {

	@Mapping(target = "passengers", ignore = true)
	FlightEntity toEntity(Flight passenger);

	@Mapping(target = "passengers", ignore = true)
	Flight toModel(FlightEntity passengerEntity);

}
