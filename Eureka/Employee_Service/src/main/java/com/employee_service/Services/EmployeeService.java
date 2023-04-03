package com.employee_service.Services;
import com.employee_service.Entities.Employee;
import com.employee_service.Repositories.EmployeeRepository;
import com.employee_service.Responses.AddressResponse;
import com.employee_service.Responses.EmployeeResponse;
import com.employee_service.Responses.ExprienceResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository ;

    @Autowired
    private ModelMapper modelMapper ;

    @Autowired
    private RestTemplate restTemplate ;

    @Value("${addressservice.base.url}")
    private String addressBase ;

    @Value("${exprienceservice.base.url}")
    private String exprienceBase ;

    @Autowired
    private WebClient webClient ;

    @Autowired
    private WebClient webClient1 ;

    public EmployeeResponse  findEmployeeById (int id ){
//        Set the data for addressResponse by making a rest api call
        AddressResponse addressResponse = new AddressResponse() ;
        /*
           This is the process to call External api using rest template ==>
        addressResponse = restTemplate.getForObject(addressBase+"{id}" ,  AddressResponse.class  , id) ;
        */
        addressResponse = (AddressResponse) webClient
                .get()
                .uri(""+id)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();

        Employee employee = employeeRepository.findById(id).get() ;
         EmployeeResponse employeeResponse = modelMapper.map(employee , EmployeeResponse.class);
         employeeResponse.setAddressResponse(addressResponse);


        ExprienceResponse exprienceResponse = new ExprienceResponse() ;

        exprienceResponse = (ExprienceResponse) webClient1
                .get()
                .uri(""+id)
                .retrieve()
                .bodyToMono(ExprienceResponse.class)
                .block();

        employeeResponse.setExprienceResponse(exprienceResponse);
        return employeeResponse ;
    }


    public String addNewEmployee ( Employee employee ){
        employeeRepository.save(employee) ;
        return employee.getName()+" added!" ;
    }
}
