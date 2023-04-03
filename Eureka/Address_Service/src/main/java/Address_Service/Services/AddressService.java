package Address_Service.Services;
import Address_Service.Entities.Address;
import Address_Service.Repositories.AddressRepository;
import Address_Service.Responses.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {


    @Autowired
    private AddressRepository addressRepository ;


    @Autowired
    private ModelMapper modelMapper ;


    public AddressResponse getAddressByEmployeeId ( int employeeId ){
        Address address = addressRepository.findAddressById(employeeId) ;
        AddressResponse addressResponse = modelMapper.map(address , AddressResponse.class) ;
        return addressResponse ;
    }

    public String addNewAddress ( Address address ){
        addressRepository.save(address) ;
        return "New Address added successfully" ;
    }
}
