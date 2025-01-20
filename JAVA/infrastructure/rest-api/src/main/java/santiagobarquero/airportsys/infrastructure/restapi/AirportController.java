package santiagobarquero.airportsys.infrastructure.restapi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import santiagobarquero.airportsys.application.service.AirportService;
import santiagobarquero.airportsys.domain.model.data.DataAirport;
import santiagobarquero.airportsys.domain.model.service.CreateAirport;

@RestController
@RequestMapping("/airports")
@AllArgsConstructor
public class AirportController {

    private AirportService airportService;

    @GetMapping("/all")
    ResponseEntity<DataAirport> getAllAirports() {
        return ResponseEntity.ok(DataAirport.builder().data(airportService.getAll()).build());
    }

    @PostMapping
    ResponseEntity<HttpStatus> create(@RequestBody CreateAirport createAirport) {
        airportService.create(createAirport);
        return ResponseEntity.ok(null);
    }

}
