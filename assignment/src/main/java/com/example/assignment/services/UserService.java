package com.example.assignment.services;

import com.example.assignment.dto.AuthDto;
import com.example.assignment.dto.ResetDto;
import com.example.assignment.dto.Response;
import com.example.assignment.models.User;
import com.example.assignment.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder , UserRepository userRepository){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Response register(AuthDto registerDto){
        try {
            User user = userRepository.findByUsername(registerDto.getUsername());
            if(user!=null){
                throw new RuntimeException("User Already Exists");
            }
            User newUser = new User();
            newUser.setUsername(registerDto.getUsername());
            newUser.setPassword(bCryptPasswordEncoder.encode(registerDto.getPassword()));
            newUser.setRole("ROLE_USER");
            userRepository.save(newUser);
            Response response = new Response();
            response.setMessage("User Registered Successfully");
            response.setUser(newUser);
            return response;

        }catch (Exception e){
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return response;
        }
    }

    public Response resetPassword(ResetDto resetDto){
        try{
            String username = resetDto.getUsername();
            User user = userRepository.findByUsername(username);
            Response response = new Response();
            if(user!=null && resetDto.getNewPassword().equals(resetDto.getConfirmPassword())){
                user.setPassword(bCryptPasswordEncoder.encode(resetDto.getConfirmPassword()));
                userRepository.save(user);

                response.setMessage("Password Reset Successfully");
            }
            return response;

        }catch (Exception e){
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return response;
        }
    }
}
