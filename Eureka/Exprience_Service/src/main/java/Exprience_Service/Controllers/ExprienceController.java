package Exprience_Service.Controllers;

import Exprience_Service.Entities.Exprience;
import Exprience_Service.Responses.ExprienceResponse;
import Exprience_Service.Services.ExprienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exprience")
public class ExprienceController {


    @Autowired
    private ExprienceService exprienceService ;


    @GetMapping("/{id}")
    public ResponseEntity<ExprienceResponse> findExprienceById (@PathVariable ("id") int id ){
           ExprienceResponse exprienceResponse = exprienceService.findExprienceById(id) ;
           return new ResponseEntity<>( exprienceResponse , HttpStatus.FOUND) ;
    }

    @PostMapping ("/add")
    public ResponseEntity < String > addNewExprience (@RequestBody Exprience exprience ){
        String result = exprienceService.addNewExprience(exprience) ;
        return new ResponseEntity<>( result , HttpStatus.CREATED) ;
    }
}
