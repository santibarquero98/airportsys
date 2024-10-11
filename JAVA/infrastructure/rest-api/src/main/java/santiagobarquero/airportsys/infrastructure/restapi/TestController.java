package santiagobarquero.airportsys.infrastructure.restapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    ResponseEntity<String> testing() {
        return ResponseEntity.ok("Sample!!");
    }

}
