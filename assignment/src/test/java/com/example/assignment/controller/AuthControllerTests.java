package com.example.assignment.controller;


import com.example.assignment.controllers.AuthController;
import com.example.assignment.dto.AuthDto;
import com.example.assignment.dto.ResetDto;
import com.example.assignment.dto.Response;
import com.example.assignment.models.User;
import com.example.assignment.repository.UserRepository;
import com.example.assignment.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthControllerTests {
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    private MockMvc mockMvc;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        AuthController authController = new AuthController(authenticationManager, userService, userRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
    }

    @Test
    void registerUser() throws Exception {
        AuthDto authDto = new AuthDto();
        authDto.setUsername("test-user");
        authDto.setPassword("test-pass");
        Response response = new Response();
        response.setMessage("User Registered Successfully");

        when(userService.register(authDto)).thenReturn(response);

        mockMvc.perform(post("/auth/register").contentType("application/json").content("{\"username\" : \"test-user\",\"password\" : \"test-pass\" }")
               ).andExpect(status().isOk()
                ).andExpect(jsonPath("$.message").value("User Registered Successfully"));
    }

    @Test
    void login() throws Exception{
        AuthDto authDto = new AuthDto();
        authDto.setUsername("test-user");
        authDto.setPassword("test-pass");
        User user = new User();
        user.setUsername("test-user");

        Response response = new Response();
        response.setMessage("Login Successful");
        response.setUser(user);

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(null);
        when(userRepository.findByUsername("test-user")).thenReturn(user);
        mockMvc.perform(post("/auth/login")
                        .contentType("application/json")
                        .content("{\"username\":\"test-user\", \"password\":\"test-pass\"}")
                )
                .andExpect(status().isOk())
                .andExpect(
                        jsonPath("$.message").
                                value("Login Successful")
                )
                .andExpect(jsonPath
                        ("$.user.username").value(
                                "test-user"));

    }
    @Test
    void resetPassword() throws Exception {
        // Arrange
        ResetDto resetDto = new ResetDto();
        resetDto.setUsername("test-user");
        resetDto.setNewPassword("new-password");
        resetDto.setConfirmPassword("new-password");
        Response response = new Response();
        response.setMessage("Password Reset Successfully");
        User user = new User();
        user.setUsername("test-user");
        when(userRepository.findByUsername("test-user")).thenReturn(user);
        when(userService.resetPassword(resetDto)).thenReturn(response);


        mockMvc.perform(post("/auth/reset-password")
                        .contentType("application/json")
                        .content("{\"username\":\"test-user\", \"newPassword\":\"new-password\", \"confirmPassword\":\"new-password\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Password Reset Successfully"));
    }

}
