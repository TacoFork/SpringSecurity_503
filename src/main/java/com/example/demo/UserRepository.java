package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{     //Choose the User from the one you created (com.example.demo)
    //CRUD - Create, read, update, delete
    User findByUsername(String username); //"User" needs to be what is listed in CrudRepository. findByUsername needs to be written exactly the same.

}
