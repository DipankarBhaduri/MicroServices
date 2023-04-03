package Exprience_Service.Repositories;

import Exprience_Service.Entities.Exprience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExprienceRepository extends JpaRepository < Exprience , Integer >  {

}
