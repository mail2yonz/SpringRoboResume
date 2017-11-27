package com.example.demo.Repository;


import com.example.demo.Entity.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserData,Long>{


    UserData findByUsername(String username);
    UserData findByEmail(String email);
    Long countByEmail(String email);

    Long countByUsername(String username);
}
