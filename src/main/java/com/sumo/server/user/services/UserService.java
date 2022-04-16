package com.sumo.server.user.services;

import com.sumo.server.user.entities.Role;
import com.sumo.server.user.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getUsers();

}
