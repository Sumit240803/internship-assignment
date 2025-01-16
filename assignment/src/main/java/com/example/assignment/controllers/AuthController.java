package com.example.assignment.controllers;

import com.example.assignment.dto.AuthDto;
import com.example.assignment.dto.ResetDto;
import com.example.assignment.dto.Response;
import com.example.assignment.models.User;
import com.example.assignment.repository.UserRepository;
import com.example.assignment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager , UserService userService , UserRepository userRepository){
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody AuthDto registerDto){
        try {
            Response response = userService.register(registerDto);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody AuthDto loginDto){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername() , loginDto.getPassword()));
            User user = userRepository.findByUsername(loginDto.getUsername());
            Response response = new Response();
            response.setMessage("Login Successful");
            response.setUser(user);
            return ResponseEntity.ok().body(response);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> reset(@RequestBody ResetDto resetDto){
        try{
            Response response = userService.resetPassword(resetDto);
            return ResponseEntity.ok().body(response);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
