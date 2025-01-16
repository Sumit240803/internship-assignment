package com.example.assignment.service;

import com.example.assignment.dto.AuthDto;
import com.example.assignment.dto.ResetDto;
import com.example.assignment.dto.Response;
import com.example.assignment.models.User;
import com.example.assignment.repository.UserRepository;
import com.example.assignment.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @InjectMocks
    private UserService userService;

    private User user;
    private ResetDto resetDto;
    private AuthDto authDto;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        authDto = new AuthDto();
        authDto.setUsername("test-user");
        authDto.setPassword("test-password");

        resetDto = new ResetDto();
        resetDto.setUsername("test-user");
        resetDto.setNewPassword("new-password");
        resetDto.setConfirmPassword("new-password");

        user = new User();
        user.setUsername("test-user");
        user.setPassword("old");
        user.setRole("user-role");
    }

    @Test
    public void testRegister(){
        when(
                userRepository.findByUsername("test-user")
        ).thenReturn(null);
        when(bCryptPasswordEncoder.encode("user-pass")).thenReturn("encoded-password");

        Response response = userService.register(authDto);

        assertNotNull(response);
        assertEquals("User Registered Successfully", response.getMessage());
        assertEquals("test-user", response.getUser().getUsername());
    }

    @Test
    public void resetPassword(){
        resetDto.setConfirmPassword("new-password");
        when(userRepository.findByUsername("test-user")).thenReturn(user);
        when(bCryptPasswordEncoder.encode("new-password")).thenReturn("encoded-new-password");

        Response response = userService.resetPassword(resetDto);

        assertNotNull(response);
        assertEquals("Password Reset Successfully", response.getMessage());
        assertEquals("encoded-new-password", user.getPassword());
    }
}
