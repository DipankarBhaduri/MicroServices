package Address_Service.Entities;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="address")
@Data
public class Address {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id ;

    private String line_1 ;
    private String line_2 ;
    private String state ;
    private int zip ;
//    private int employee_id ;
}
