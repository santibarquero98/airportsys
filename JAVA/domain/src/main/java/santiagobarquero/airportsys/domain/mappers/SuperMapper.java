package santiagobarquero.airportsys.domain.mappers;

import java.util.List;

public interface SuperMapper<MODEL, ENTITY> {

    abstract ENTITY toEntity(MODEL passenger);

    abstract MODEL toModel(ENTITY passengerEntity);

    abstract List<ENTITY> toEntityList(List<MODEL> passengerList);

    abstract List<MODEL> toModelList(List<ENTITY> passengerEntityList);

}
