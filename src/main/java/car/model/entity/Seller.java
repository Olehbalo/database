package car.model.entity;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Seller {

    private Integer id;
    private String firstName;
    private String email;
    private String lastName;
    private Integer phoneNumber;
    public Seller (Integer id, String firstName, String email, String lastName, Integer phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.lastName =lastName;
        this.phoneNumber = phoneNumber;
    }

    public Seller(String firstName, String email, String lastName, Integer phoneNumber) {
        this(null, firstName, email, lastName, phoneNumber);
    }

    @Override
    public String toString() {
        return "\n\nAmenity: id: " + id + ", first name: " + firstName + ", email: " + email
                + ", last name: " + lastName + ", phone number: " + phoneNumber
                + "]";
    }
}
