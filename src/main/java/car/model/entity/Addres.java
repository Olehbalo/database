package car.model.entity;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Addres {

    private Integer id;
    private String city;
    private String street;

    public Addres(Integer id,  String city, String street) {
        this.id = id;
        this.city = city;
        this.street = street;
    }

    public Addres( String city, String street) {
        this(null, city, street);
    }

    @Override
    public String toString() {
        return "\n\nAddres: id: " + id + ", city: " + city + ", street: " + street
                + "]";
    }
}
