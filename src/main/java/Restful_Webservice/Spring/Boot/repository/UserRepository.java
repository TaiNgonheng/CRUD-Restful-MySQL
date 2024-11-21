package Restful_Webservice.Spring.Boot.repository;

import Restful_Webservice.Spring.Boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
}
