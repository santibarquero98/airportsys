package santiagobarquero.airportsys.infrastructure.restapi;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import santiagobarquero.airportsys.application.exceptions.ExceptionMessagesHelper;
import santiagobarquero.airportsys.application.service.FlightService;
import santiagobarquero.airportsys.application.service.PassengerService;
import santiagobarquero.airportsys.domain.entities.FlightEntity;
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
    ResponseEntity<HttpStatus> assignFlight(@RequestParam(name = "flightCode") String flightCode, @RequestParam(name = "nPassenger") String nif) {
        passengerService.assignFlight(nif, flightService.findByFlightCode(flightCode).orElseThrow(() -> new EntityNotFoundException(ExceptionMessagesHelper.getEntityNotFoundExceptionMsg(FlightEntity.class.getCanonicalName()))));
        return ResponseEntity.ok(null);
    }

}
