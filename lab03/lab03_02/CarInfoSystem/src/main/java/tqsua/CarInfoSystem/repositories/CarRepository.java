package tqsua.CarInfoSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import tqsua.CarInfoSystem.entities.Car;

import java.util.List;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {

    public Car findByCarId(long carId);
    public List<Car> findAll();

}
