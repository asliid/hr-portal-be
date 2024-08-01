package com.aslidongez.project.service;

import com.aslidongez.project.entity.Users;

import java.util.List;

public interface UsersService {

    List<Users> getAllUsers();

    Users saveOneUser(Users newUser);

    Users getOneUser(Long userId);

    Users updateOneUser(Long userId, Users newUsers);

    void deleteById(Long userId);

   // Users getOneUserByUsername(String username);
}
