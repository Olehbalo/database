package car.model.entity;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Customer {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    public Customer (Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Customer(String firstName, String lastName, String email) {
        this(null, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "\n\nAmenity: id: " + id + ", first name: " + firstName + ", last name: " + lastName
                +", email"+ email
                + "]";
    }
}
