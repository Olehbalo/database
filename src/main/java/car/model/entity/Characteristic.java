package car.model.entity;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Characteristic {


            private Integer id;
            private String drive;
            private String color;
            private String carBody;
            private String transmission;
            private Integer carId;

            public Characteristic(Integer id, String drive, String color, String carBody,String transmission, Integer carId ) {
                this.id = id;
                this.drive = drive;
                this.color = color;
                this.carBody = carBody;
                this.transmission = transmission;
                this.carId = carId;
            }

            public Characteristic(String drive, String color, String carBody,String transmission, Integer carId) {
                this(null, drive, color, carBody, transmission, carId);
            }

            @Override
            public String toString() {
                return "\n\nHotel chain: id: " + id + ", drive: " + drive + ", color: " + color + ", carBody: " + carBody
                        + " transmission :"+ transmission +" carId: " +carId
                        + "]";
            }


        }
