package car.model.entity;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class TestDrive {

    private Integer id;
    private String brand;
    private Integer carId;

    public TestDrive (Integer id,  String brand, Integer carId) {
        this.id = id;
        this.brand = brand;
        this.carId = carId;
    }

    public TestDrive(String brand, Integer carId) {
        this(null,  brand, carId);
    }

    @Override
    public String toString() {
        return "\n\nTest drive: id: " + id + ", brand: " + brand + ", carId: " + carId
                + "]";
    }
}
