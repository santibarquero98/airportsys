package santiagobarquero.airportsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "santiagobarquero.airportsys")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}