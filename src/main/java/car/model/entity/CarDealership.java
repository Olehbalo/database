package car.model.entity;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class CarDealership {

    private Integer id;
    private String site;
    private String email;
    private Integer carId;
    private Integer addresId;

    public CarDealership (Integer id, String site, String email, Integer carId, Integer addresId) {
        this.id = id;
        this.site = site;
        this.email = email;
        this.carId = carId;
        this.addresId = addresId;
    }

    public CarDealership(String site, String email, Integer carId, Integer addresId) {
        this(null, site, email, carId, addresId);
    }

    @Override
    public String toString() {
        return "\n\n:Car Dealership  id: " + id + ", site: " + site + ", email: " + email
                +", car id: " + carId + ", addres id: " +addresId
                + "]";
    }
}
