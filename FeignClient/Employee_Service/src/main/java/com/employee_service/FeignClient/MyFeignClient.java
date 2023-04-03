package com.employee_service.FeignClient;

import com.employee_service.Responses.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//  http://localhost:8080/address/1
@FeignClient(name="abc" , url="http://localhost:51557")
public interface MyFeignClient {

    @GetMapping("/address/{id}")
    AddressResponse getAddressByEmployeeId(@PathVariable("id") int id) ;

}
