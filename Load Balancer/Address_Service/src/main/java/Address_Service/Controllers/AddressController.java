package Address_Service.Controllers;
import Address_Service.Entities.Address;
import Address_Service.Responses.AddressResponse;
import Address_Service.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService ;

    @GetMapping("/{id}")
    public ResponseEntity< AddressResponse > getAddressByEmployeeId (@PathVariable("id") int employeeId ){
        AddressResponse addressResponse = addressService.getAddressByEmployeeId ( employeeId) ;
        return new ResponseEntity<>( addressResponse , HttpStatus.OK );
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewAddress (@RequestBody Address address ){
        String result = addressService.addNewAddress(address) ;
        return new ResponseEntity<>( result , HttpStatus.CREATED) ;
    }
}
