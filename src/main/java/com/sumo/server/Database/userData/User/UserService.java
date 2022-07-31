package com.sumo.server.Database.userData.User;

import com.sumo.server.Database.userData.PersonalDetails.PersonalDetails;
import com.sumo.server.Database.userData.Role.Role;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    PersonalDetails savePersonalDetails(PersonalDetails personalDetails);

    void addRoleToUser(String username, String roleName);

    void setUserPersonalDetails(String username, Long personalDetails);

    User getUser(String username);

    List<User> getUsers();
}
