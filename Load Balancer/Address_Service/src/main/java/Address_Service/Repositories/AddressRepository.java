package Address_Service.Repositories;
import Address_Service.Entities.Address;
import Address_Service.Responses.AddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository < Address, Integer > {

    // <== Native query For join Column ==>
     @Query ( value = "SELECT ea.id , ea.line_1 ,ea.line_2,ea.state,ea.zip from selenium_express.address ea \n" +
             "join\n" +
             "selenium_express.employee e\n" +
             "on e.id=ea.employee_id \n" +
             "where employee_id =:id ;" , nativeQuery = true )
     Address findAddressById ( int id ) ;
}
