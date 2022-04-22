package tqsua.CarInfoSystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tqsua.CarInfoSystem.entities.Car;
import tqsua.CarInfoSystem.repositories.CarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class CarRestControllerSBTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarRepository repository;

    @AfterEach
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void whenValidInput_thenSave() {
        Car car01 = new Car("FORD", "Polsa");

        ResponseEntity<Car> entity = restTemplate.postForEntity("/api/cars", car01, Car.class);

        List<Car> cars = repository.findAll();
        assertThat(cars).hasSize(1);
        assertThat(cars).extracting(Car::getMaker).containsOnly(car01.getMaker());
        assertThat(cars).extracting(Car::getModel).containsOnly(car01.getModel());

    }

    @Test
    public void whenGetCars_return200() {
        saveTestCar("FORD", "Polsa");
        saveTestCar("Renault", "creative");

        ResponseEntity<List<Car>> response = restTemplate.exchange(
                "/api/cars", HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>() {}
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting(Car::getMaker).contains("FORD", "Renault");
        assertThat(response.getBody()).extracting(Car::getModel).contains("Polsa", "creative");

    }

    private void saveTestCar(String maker, String model) {
        repository.saveAndFlush(new Car(maker, model));
    }

}
