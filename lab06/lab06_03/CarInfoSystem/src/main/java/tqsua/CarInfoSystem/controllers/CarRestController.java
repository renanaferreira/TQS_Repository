package tqsua.CarInfoSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import tqsua.CarInfoSystem.entities.Car;
import tqsua.CarInfoSystem.services.CarManagerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarRestController {

    @Autowired
    private CarManagerService service;

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        System.out.printf("car01-2: %s\n", car.getMaker());
        Car saved = service.save(car);
        System.out.printf("car01-3: %s\n", saved.getMaker());
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return service.getAllCars();
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable(value = "id") long carId) {
        ResponseEntity<Car> response;
        Optional<Car> found = service.getCarDetails(carId);
        try {
            Car car = found.get();
            response = new ResponseEntity<>(car, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return response;
    }


}
