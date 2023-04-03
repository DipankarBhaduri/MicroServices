package com.employee_service.Services;
import com.employee_service.Entities.Employee;
import com.employee_service.Repositories.EmployeeRepository;
import com.employee_service.Responses.AddressResponse;
import com.employee_service.Responses.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository ;

    @Autowired
    private ModelMapper modelMapper ;

    @Autowired
    private RestTemplate restTemplate ;

//    @Autowired
//    private DiscoveryClient discoveryClient ;


    @Value("${addressservice.base.url}")
    private String addressBase ;


    @Value("${exprienceservice.base.url}")
    private String exprienceBase ;


    @Autowired
    private WebClient webClient ;


    @Autowired
    private WebClient webClient1 ;


    @Autowired
    private LoadBalancerClient loadBalancerClient ;


    public EmployeeResponse  findEmployeeById (int id ){
//        Set the data for addressResponse by making a rest api call
        AddressResponse addressResponse = new AddressResponse() ;
//        List<ServiceInstance> instanceList = discoveryClient.getInstances("address_Service") ;
//        ServiceInstance serviceInstance = instanceList.get(0) ;
//        String uri = serviceInstance.getUri().toString() ;

        ServiceInstance serviceInstance = loadBalancerClient.choose("address_Service") ;
        String uri = serviceInstance.getUri().toString() ;

           //This is the process to call External api using rest template ==>
//        addressResponse = restTemplate.getForObject(addressBase+"{id}" ,  AddressResponse.class  , id) ;
        addressResponse = restTemplate.getForObject(uri+"/address/{id}" ,  AddressResponse.class  , id) ;
        System.out.println("URI >-----------------------------------------------------------> "+ uri);

//        addressResponse = (AddressResponse) webClient
//                .get()
//                .uri(""+id)
//                .retrieve()
//                .bodyToMono(AddressResponse.class)
//                .block();

        Employee employee = employeeRepository.findById(id).get() ;
         EmployeeResponse employeeResponse = modelMapper.map(employee , EmployeeResponse.class) ;
         employeeResponse.setAddressResponse(addressResponse) ;

//        ExprienceResponse exprienceResponse = new ExprienceResponse() ;
//
//        exprienceResponse = (ExprienceResponse) webClient1
//                .get()
//                .uri(""+id)
//                .retrieve()
//                .bodyToMono(ExprienceResponse.class)
//                .block();
//
//        employeeResponse.setExprienceResponse(exprienceResponse);
        return employeeResponse ;
    }


    public String addNewEmployee ( Employee employee ){
        employeeRepository.save(employee) ;
        return employee.getName()+" added!" ;
    }
}
