package com.employee_service.Services;
import com.employee_service.Entities.Employee;
import com.employee_service.FeignClient.MyFeignClient;
import com.employee_service.Repositories.EmployeeRepository;
import com.employee_service.Responses.AddressResponse;
import com.employee_service.Responses.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository ;

    @Autowired
    private ModelMapper modelMapper ;

    @Autowired
    private MyFeignClient myFeignClient ;

    public EmployeeResponse  findEmployeeById (int id ){
//        Set the data for addressResponse by making a rest api call
        AddressResponse addressResponse = new AddressResponse() ;

        addressResponse = myFeignClient.getAddressByEmployeeId(id) ;


        Employee employee = employeeRepository.findById(id).get() ;
         EmployeeResponse employeeResponse = modelMapper.map(employee , EmployeeResponse.class);
         employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse ;
    }




    public String addNewEmployee ( Employee employee ){
        employeeRepository.save(employee) ;
        return employee.getName()+" added!" ;
    }
}
