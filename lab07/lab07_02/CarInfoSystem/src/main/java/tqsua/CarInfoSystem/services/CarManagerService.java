package tqsua.CarInfoSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tqsua.CarInfoSystem.entities.Car;
import tqsua.CarInfoSystem.repositories.CarRepository;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CarManagerService {

    @Autowired
    private CarRepository repository;

    public Car save(Car car) {
        return repository.save(car);
    }

    public List<Car> getAllCars() {
        return repository.findAll();
    }

    public Optional<Car> getCarDetails(long carId) {
        Car car = repository.findByCarId(carId);
        if (car == null) {
            return Optional.empty();
        }
        return Optional.of(car);
    }

}
