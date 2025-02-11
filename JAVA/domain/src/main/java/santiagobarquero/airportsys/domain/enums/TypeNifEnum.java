package santiagobarquero.airportsys.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeNifEnum {

	DNI("Documento Nacional de Identidad"), NIE("Numero de Identificacion de Extrajero");
	
	private final String description;

}
