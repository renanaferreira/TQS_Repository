package tqsua.CarInfoSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import tqsua.CarInfoSystem.entities.Car;
import tqsua.CarInfoSystem.repositories.CarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private TestEntityManager manager;

    @Autowired
    private CarRepository repository;


    @BeforeEach
    public void setUp() {}

    @Test
    public void whenFoundCarId_thenReturnCar() {
        Car car = new Car("FORD", "polsa");
        manager.persistAndFlush(car);

        Car found = repository.findByCarId(car.getCarId());
        assertThat(found).isEqualTo(car);
    }

    @Test
    public void whenInvalidCarId_thenReturnNull() {
        Car nulled = repository.findByCarId(-99L);
        assertThat(nulled).isNull();
    }

    @Test
    public void returnAllCars() {
        Car car01 = new Car("FORD", "polsa");
        Car car02 = new Car("Renault", "carrao");
        Car car03 = new Car("BMW", "fancy");

        manager.persist(car01);
        manager.persist(car02);
        manager.persist(car03);
        manager.flush();

        List<Car> allCars = repository.findAll();
        assertThat(allCars).hasSize(3).extracting(Car::getMaker).contains(car01.getMaker(),car02.getMaker(),car03.getMaker());
        assertThat(allCars).extracting(Car::getModel).contains(car01.getModel(),car02.getModel(),car03.getModel());

    }



}
