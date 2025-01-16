package com.example.assignment.repository;

import com.example.assignment.models.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AssignmentRepositoryUnitTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Test1- Saving User")
    @Order(1)
    @Rollback(value = false)
    public void registerUser(){
        User user = new User();
        user.setUsername("test-user");
        user.setPassword("test-password");
        user.setRole("test-role");

        User savedUser = userRepository.save(user);
        assertNotNull(savedUser);
        assertEquals(user.getUsername() , savedUser.getUsername());
        assertEquals(user.getPassword(),savedUser
                .getPassword());
        assertEquals(user.getRole() , savedUser.getRole());
    }
}
