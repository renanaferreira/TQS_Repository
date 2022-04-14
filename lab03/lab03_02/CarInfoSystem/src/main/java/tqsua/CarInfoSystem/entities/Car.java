package tqsua.CarInfoSystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;

    @NotNull
    private String maker;
    private String model;

    public Car() {}

    public Car(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    public void setCarId(Long id) {
        this.carId = id;
    }

    public Long getCarId() {
        return carId;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Car other = (Car) obj;
        if (this.getMaker() != other.getMaker()) {
            return false;
        }
        if (this.getModel() != other.getModel()) {
            return false;
        }
        return this.getCarId()==other.getCarId();
    }

    @Override
    public int hashCode() {
        int hash = 31;
        hash = hash * getCarId().hashCode();
        hash = hash * getMaker().hashCode();
        hash = hash * getModel().hashCode();
        return hash;
    }
}
