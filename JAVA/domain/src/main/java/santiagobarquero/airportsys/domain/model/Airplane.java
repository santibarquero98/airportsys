package santiagobarquero.airportsys.domain.model;

import lombok.Builder;

@Builder
public record Airplane(Long id, String code, String name, Integer maxPassengers, Integer yearOfConstruction) {

}
