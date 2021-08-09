package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public void run(String...args){
        User user = new User("bart", "bart@domain.com", "bart", "Bart", "Simpson", true);
        Role userRole = new Role("bart", "ROLE_USER"); //specifies the role

        userRepository.save(user); //saving user object
        roleRepository.save(userRole); //saving userRole object

        User admin = new User("super", "super@domain.com", "super", "Super", "Hero", true);
        Role adminRole1 = new Role("super", "ROLE_ADMIN");
        Role adminRole2 = new Role("super", "ROLE_USER");

        userRepository.save(admin);
        roleRepository.save(adminRole1);
        roleRepository.save(adminRole2);

    }

    //big picture = defining own schema (user and role classes) and with this new schema we are creating our own specified users/roles
}
