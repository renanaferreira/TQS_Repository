package tqsua.CarInfoSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tqsua.CarInfoSystem.entities.Car;
import tqsua.CarInfoSystem.entities.CarDTO;
import tqsua.CarInfoSystem.services.CarManagerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarRestController {

    @Autowired
    private CarManagerService service;

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody CarDTO carDTO) {
        Car car = new Car(carDTO.getMaker(), carDTO.getModel());
        System.out.printf("car01-2: %s\n", car.getMaker());
        Car saved = service.save(car);
        System.out.printf("car01-3: %s\n", saved.getMaker());
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return service.getAllCars();
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public ResponseEntity<Car> getCarById(@PathVariable(value = "id") long carId) {

        Optional<Car> found = service.getCarDetails(carId);

        Car car;
        HttpStatus status;
        if(found.isPresent()) {
            car = found.get();
            status = HttpStatus.OK;
        } else {
            car = null;
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(car, status);
    }


}
