package car.model.entity;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Site {

    private Integer id;
    private Integer carDealershipId;
    private Integer carId;

    public Site (Integer id, Integer carDealershipId,  Integer carId) {
        this.id = id;
        this.carDealershipId = carDealershipId;
        this.carId = carId;
    }

    public Site(Integer carDealershipId,  Integer carId) {
        this(null, carDealershipId,  carId);
    }

    @Override
    public String toString() {
        return "\n\nAmenity: id: " + id + ", car Dealership Id: " + carDealershipId + ", car id: " + carId
                + "]";
    }
}
