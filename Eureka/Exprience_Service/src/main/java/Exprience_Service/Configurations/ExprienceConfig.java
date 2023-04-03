package Exprience_Service.Configurations;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExprienceConfig {


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper() ;
    }
}
