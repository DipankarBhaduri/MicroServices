package Exprience_Service.Services;


import Exprience_Service.Entities.Exprience;
import Exprience_Service.Repositories.ExprienceRepository;
import Exprience_Service.Responses.ExprienceResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExprienceService {

    @Autowired
    private ExprienceRepository exprienceRepository ;

    @Autowired
    private ModelMapper modelMapper ;

    public ExprienceResponse findExprienceById ( int id ){
        Exprience exprience = exprienceRepository.findById(id).get() ;
        ExprienceResponse exprienceResponse = modelMapper.map(exprience , ExprienceResponse.class) ;
        return exprienceResponse ;
    }

    public String addNewExprience ( Exprience exprience ){
        exprienceRepository.save(exprience) ;
        return "Exprience added sucessfully" ;
    }
}
