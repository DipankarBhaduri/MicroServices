package Address_Service.Responses;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {

    private int id ;
    private String line_1 ;
    private String line_2 ;
    private String state ;
    private int zip ;
}
