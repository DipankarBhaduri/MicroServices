package Exprience_Service.Entities;
import lombok.Data;
import lombok.Value;

import javax.persistence.*;
import java.time.Year;

@Data
@Entity
@Table(name = "exprience")
public class Exprience {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id ;

    private int yearOfExprience ;

    private Year startYear ;

    private  Year endYear ;

    private String nameOfCompany ;

    private String location ;

    private String designation ;

    private int  employee_id ;
}
