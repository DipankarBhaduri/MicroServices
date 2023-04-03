package com.employee_service.Responses;


import lombok.*;

@Getter
@Setter
@Data
public class EmployeeResponse {

    private int id ;

    private String name ;

    private String email ;

    private String blood_group ;

    private AddressResponse addressResponse ;
    private ExprienceResponse exprienceResponse ;

}
