package com.aslidongez.project.service.impl;

import com.aslidongez.project.entity.Users;
import com.aslidongez.project.repository.UsersRepository;
import com.aslidongez.project.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;
    @Override
    public List<Users> getAllUsers(){

        return usersRepository.findAll();
    }

    @Override
    public Users getOneUser(Long userId) {

        return usersRepository.findById(userId).orElse(null);
    }
    @Override
    public Users saveOneUser(Users newUsers) {
        return  usersRepository.save(newUsers);
    }
    @Override
    public Users updateOneUser(Long userId, Users newUsers){
        Optional<Users> users =usersRepository.findById(userId);
        if(users.isPresent()){
            Users foundUsers=users.get();
            foundUsers.setUsername(newUsers.getUsername());
            foundUsers.setPassword(newUsers.getPassword());
            usersRepository.save(foundUsers);
            return foundUsers;
        }
        else
            return null;

    }
    @Override
    public void deleteById(Long userId){
        usersRepository.deleteById(userId);
    }


   /* public Users getOneUserByUsername(String username){
        return usersRepository.findByUsername(username);
    }*/


}
