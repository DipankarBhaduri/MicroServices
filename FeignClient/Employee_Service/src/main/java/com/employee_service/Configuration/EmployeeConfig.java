package com.employee_service.Configuration;
import com.employee_service.FeignClient.MyFeignClient;
import com.employee_service.Responses.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    public ModelMapper modelMapper (){
        return new ModelMapper() ;
    }

    }



