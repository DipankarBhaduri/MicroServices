package com.employee_service.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="employee")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String name ;

    private String email ;

    private String blood_group ;

}
