package santiagobarquero.airportsys.infrastructure.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import santiagobarquero.airportsys.application.service.FlightService;
import santiagobarquero.airportsys.application.service.PassengerService;
import santiagobarquero.airportsys.domain.model.Passenger;
import santiagobarquero.airportsys.domain.model.data.DataPassenger;

@RestController
@RequestMapping("/passengers")
@AllArgsConstructor
public class PassengerController {

	private final PassengerService passengerService;
	private final FlightService flightService;

	@GetMapping("/all")
	ResponseEntity<DataPassenger> getAllPassengers() {
		return ResponseEntity.ok(passengerService.getAll());
	}

	@PostMapping
	ResponseEntity<HttpStatus> create(@RequestBody Passenger passenger) {
		passengerService.create(passenger);
		return ResponseEntity.ok(null);
	}

	@PatchMapping("/assign-flight")
	ResponseEntity<HttpStatus> assignFlight(@RequestParam(name = "flightCode") String flightCode,
			@RequestParam(name = "nif") String nif) {
		passengerService.assignFlight(nif, flightCode);
		return ResponseEntity.ok(null);
	}

}
