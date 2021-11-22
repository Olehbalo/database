package car.model.entity;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Car {

    private Integer id;
    private String brand;
    private Integer graduathionYear;
    private Integer serNum;
    private Boolean isNew;
    private Boolean isSold;
    private Integer commentId;
    private Integer sellerId;

    public Car (Integer id, String brand, Integer graduathionYear, Integer serNum, Boolean isNew,
                Boolean isSold, Integer commentId,Integer sellerId) {
        this.id = id;
        this.brand = brand;
        this.graduathionYear = graduathionYear;
        this.serNum = serNum;
        this.isNew = isNew;
        this.isSold = isSold;
        this.commentId = commentId;
        this.sellerId = sellerId;


    }

    public Car(String brand, Integer graduathionYear, Integer serNum, Boolean isNew,
               Boolean isSold, Integer commentId,Integer sellerId) {
        this(null, brand, graduathionYear, serNum, isNew, isSold, commentId, sellerId);
    }

    @Override
    public String toString() {
        return "\n\n Car id: " + id + ", brand: " + brand + ", graduathionYear: " + graduathionYear
                + ", serNum" + serNum+ ", isNew: " + isNew +", isSold: "+ isSold + ", commentId: " + commentId
                + ", sellerId: " + sellerId
                + "]";
    }
}
