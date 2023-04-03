package com.employee_service.Controllers;
import com.employee_service.Responses.EmployeeResponse;
import com.employee_service.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.employee_service.Entities.Employee;

@RestController
@RequestMapping("/employee")
public class Employee_Controller {
	
	@Autowired
	private EmployeeService employeeService ;

	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeDetails (@PathVariable("id") int id ) {
		EmployeeResponse employee = employeeService.findEmployeeById(id) ;
		return new ResponseEntity<>(employee , HttpStatus.OK) ;
	}

	@PostMapping("/add")
	public ResponseEntity<String> addNewEmployee ( @RequestBody Employee employee) {
		String result = employeeService.addNewEmployee( employee ) ;
		return new ResponseEntity<>( result , HttpStatus.CREATED ) ;
	}

}
