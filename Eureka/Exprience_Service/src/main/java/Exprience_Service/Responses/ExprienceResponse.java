package Exprience_Service.Responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.Year;


@Getter
@Setter
@Data
public class ExprienceResponse {

    private int id ;
    private int yearOfExprience ;
    private Year startYear ;
    private  Year endYear ;
    private String nameOfCompany ;
    private String location ;
    private String designation ;

}
