package santiagobarquero.airportsys.infrastructure.restapi;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import santiagobarquero.airportsys.application.service.FlightService;
import santiagobarquero.airportsys.domain.model.data.DataFlight;
import santiagobarquero.airportsys.domain.model.service.CreateFlight;

@RestController
@RequestMapping("/flights")
@AllArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    ResponseEntity<HttpStatus> create(@RequestBody CreateFlight createFlightRequest) {
        flightService.create(createFlightRequest);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/all")
    ResponseEntity<DataFlight> getAllFlights() {
        return ResponseEntity.ok(DataFlight.builder().data(flightService.getAll()).build());
    }

}
