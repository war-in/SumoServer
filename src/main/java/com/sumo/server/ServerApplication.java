package com.sumo.server;

import com.sumo.server.user.entities.Role;
import com.sumo.server.user.entities.User;
import com.sumo.server.user.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.ArrayList;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null,"Endriu1","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Endriu2","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Endriu3","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Endriu4","1234",new ArrayList<>()));

            userService.addRoleToUser("Endriu1","ROLE_USER");
            userService.addRoleToUser("Endriu1","ROLE_MANAGER");
            userService.addRoleToUser("Endriu1","ROLE_ADMIN");
            userService.addRoleToUser("Endriu2","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("Endriu3","ROLE_USER");
            userService.addRoleToUser("Endriu4","ROLE_USER");
            userService.addRoleToUser("Endriu2","ROLE_USER");
        };
    }

}
