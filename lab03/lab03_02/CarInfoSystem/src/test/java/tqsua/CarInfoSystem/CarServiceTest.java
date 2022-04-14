package tqsua.CarInfoSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tqsua.CarInfoSystem.entities.Car;
import tqsua.CarInfoSystem.repositories.CarRepository;
import tqsua.CarInfoSystem.services.CarManagerService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository repository;

    @InjectMocks
    private CarManagerService service;

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("FORD", "polsa");
        car.setCarId(1L);
    }

    @Test
    public void whenValidIdShouldBeFound() {

        when(repository.findByCarId(car.getCarId())).thenReturn(car);

        Car found = service.getCarDetails(car.getCarId()).get();
        assertThat(found.getCarId()).isEqualTo(car.getCarId());
        assertThat(found.getMaker()).isEqualTo(car.getMaker());
        assertThat(found.getModel()).isEqualTo(car.getModel());

        verify(repository, times(1)).findByCarId(car.getCarId());

    }

    @Test
    public void whenInvalidIdShouldNotBeFound() {

        long id = -99L;
        when(repository.findByCarId(id)).thenReturn(null);

        Optional<Car> found = service.getCarDetails(id);
        assertThat(found.isEmpty());

        verify(repository, times(1)).findByCarId(id);

    }

    @Test
    public void whenInsert3Records_return3() {
        Car car02 = new Car("renault", "pix");
        Car car03 = new Car("bmw", "fancy");

        List<Car> allCars = Arrays.asList(car, car02, car03);

        when(repository.findAll()).thenReturn(allCars);

        List<Car> foundedCars = service.getAllCars();
        assertThat(foundedCars).hasSize(3).extracting(Car::getMaker).contains(car.getMaker(), car02.getMaker(), car03.getMaker());
        assertThat(foundedCars).extracting(Car::getModel).contains(car.getModel(), car02.getModel(), car03.getModel());

        verify(repository, times(1)).findAll();
    }

}
