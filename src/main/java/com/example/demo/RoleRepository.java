package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    //interfaces allow queries by creating methods here

}
