package car.model.entity;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Comment {

    private Integer id;
    private String name;
    private String message;
    private Integer customerId ;

    public  Comment (Integer id, String name, String message, Integer customerId) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.customerId = customerId;
    }

    public Comment(String name, String message, Integer customerId) {
        this(null,  name, message, customerId);
    }

    @Override
    public String toString() {
        return "\n\nComment: id: " + id + ", name: " + name + ",message: " + message
                + "customerId"+ customerId
                + "]";
    }
}
