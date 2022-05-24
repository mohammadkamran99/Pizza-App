package com.wave17.CustomerService.repository;
import com.wave17.CustomerService.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailIdAndPassword(String emailId,String password);
}
