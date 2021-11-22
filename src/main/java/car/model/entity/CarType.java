package car.model.entity;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class CarType {

    private Integer id;
    private String type;
    private Integer carId;

    public CarType (Integer id,  String type, Integer carId) {
        this.id = id;
        this.type = type;
        this.carId = carId;
    }

    public CarType(String type, Integer carId) {
        this(null, type, carId);
    }

    @Override
    public String toString() {
        return "\n\nCar Type: id: " + id + ", type: " + type + ", carId: " + carId
                + "]";
    }
}
