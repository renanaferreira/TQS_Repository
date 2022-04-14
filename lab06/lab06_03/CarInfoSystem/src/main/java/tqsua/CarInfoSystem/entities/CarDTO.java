package tqsua.CarInfoSystem.entities;

public class CarDTO {

    private Long carId;
    private String maker;
    private String model;

    public CarDTO() {}

    public CarDTO(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
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

        CarDTO other = (CarDTO) obj;
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
