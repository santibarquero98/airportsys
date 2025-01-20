package santiagobarquero.airportsys.infrastructure.restapi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import santiagobarquero.airportsys.application.service.AirplaneService;
import santiagobarquero.airportsys.domain.model.data.DataAirplane;
import santiagobarquero.airportsys.domain.model.service.CreateAirplane;

@RestController
@RequestMapping("/airplanes")
@AllArgsConstructor
public class AirplaneController {

    private final AirplaneService airplaneService;
    
    @PostMapping
    ResponseEntity<HttpStatus> create(@RequestBody CreateAirplane createAirplane) {
        airplaneService.create(createAirplane);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/all")
    ResponseEntity<DataAirplane> getAllAirplanes() {
        return ResponseEntity.ok(DataAirplane.builder().data(airplaneService.getAll()).build());
    }

}
