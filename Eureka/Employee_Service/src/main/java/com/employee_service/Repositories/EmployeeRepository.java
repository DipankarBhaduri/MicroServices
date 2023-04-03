package com.employee_service.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employee_service.Entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
   
}
