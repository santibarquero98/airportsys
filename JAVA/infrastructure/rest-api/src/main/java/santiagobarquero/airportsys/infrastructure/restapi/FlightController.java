package santiagobarquero.airportsys.infrastructure.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import santiagobarquero.airportsys.application.exceptions.TechnicalException;
import santiagobarquero.airportsys.application.service.FlightService;
import santiagobarquero.airportsys.domain.model.data.DataFlight;
import santiagobarquero.airportsys.domain.model.service.CreateFlight;

@RestController
@RequestMapping("/flights")
@AllArgsConstructor
@Slf4j
public class FlightController {

	private final FlightService flightService;

	@PostMapping
	ResponseEntity<HttpStatus> create(@RequestBody CreateFlight createFlightRequest) {
		flightService.create(createFlightRequest);
		return ResponseEntity.ok(null);
	}

	@GetMapping("/all")
	ResponseEntity<DataFlight> getAllFlights() {
		try {
			return ResponseEntity.ok(DataFlight.builder().data(flightService.getAll()).build());
		} catch (TechnicalException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PatchMapping("/mark-on-fly/{code}")
	ResponseEntity<HttpStatus> markOnFly(@PathVariable(name = "code") String flightCode) {
		flightService.markOnFly(flightCode);
		return ResponseEntity.ok(null);
	}
	
	@PatchMapping("/set-land/{code}")
	ResponseEntity<HttpStatus> setLand(@PathVariable(name = "code") String flightCode) {
		flightService.setLand(flightCode);
		return ResponseEntity.ok(null);
	}

}
