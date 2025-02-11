package santiagobarquero.airportsys.domain.mappers;

import java.util.List;

public interface SuperMapper<M, E> {

    abstract E toEntity(M passenger);

    abstract M toModel(E passengerEntity);

    abstract List<E> toEntityList(List<M> passengerList);

    abstract List<M> toModelList(List<E> passengerEntityList);

}
