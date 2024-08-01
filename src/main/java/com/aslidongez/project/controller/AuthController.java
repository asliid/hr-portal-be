package com.aslidongez.project.controller;

import com.aslidongez.project.dto.AuthResponseDto;
import com.aslidongez.project.dto.LoginDto;
import com.aslidongez.project.dto.RegisterDto;
import com.aslidongez.project.entity.Users;
import com.aslidongez.project.models.Role;
import com.aslidongez.project.repository.RoleRepository;
import com.aslidongez.project.repository.UsersRepository;
import com.aslidongez.project.security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:3000/")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UsersRepository usersRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;
@Autowired
    public AuthController(AuthenticationManager authenticationManager, UsersRepository usersRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (usersRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        Users users = new Users();
        users.setUsername(registerDto.getUsername());
        users.setPassword(passwordEncoder.encode(registerDto.getPassword()));


       // Role ikRole = roleRepository.findByName("IK").orElseThrow(() -> new RuntimeException("Role not found"));
     //   Role envanterRole = roleRepository.findByName("ENVANTER").orElseThrow(() -> new RuntimeException("Role not found"));
       // Role adminRole = roleRepository.findByName("ADMIN").orElseThrow(() -> new RuntimeException("Role not found"));

        Role roles = roleRepository.findByName("USER").get();
        users.setRoles(Collections.singletonList(roles));

        usersRepository.save(users);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}