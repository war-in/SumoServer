package com.sumo.server;

import com.sumo.server.userData.PersonalDetails.PersonalDetails;
import com.sumo.server.userData.Role.Role;
import com.sumo.server.userData.User.User;
import com.sumo.server.userData.User.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
//        póki nie mamy nic w bazie tak dodaje użytkownika na start
//        póki nie mamy żadnych userów w bazie testów też nie piszę
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            PersonalDetails personalDetails = userService.savePersonalDetails(new PersonalDetails());
            userService.saveUser(new User(null, "Endriu1", "1234", new ArrayList<>(), null));
            userService.setUserPersonalDetails("Endriu1", personalDetails.getId());
            userService.addRoleToUser("Endriu1", "ROLE_USER");
        };
    }

}
