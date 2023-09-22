package com.novare.natflix.services;

import com.novare.natflix.exceptions.UserAlreadyExistException;
import com.novare.natflix.models.User;
import com.novare.natflix.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @MockBean
    PasswordEncoder passwordEncoder;
    private UserService  userService;


    @MockBean
    private UserRepository userRepository;


    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository, passwordEncoder);
        when(passwordEncoder.encode("Passw0r!")).thenReturn("vnivfnoieg8945hgoiuwrnobiwr@#$@$");
    }

    @Test
    void addUser_ExistingUser() {

        String existingUserEmail = "abc@gmail.com";
        User user = new User();
        user.setEmail(existingUserEmail);

        when(userRepository.findByEmail(existingUserEmail)).thenReturn(user);
        assertThrows(UserAlreadyExistException.class,() -> userService.addUser(user));
    }

    @Test
    void addUser_NonExistingUser() {

        String existingUserEmail = "abc@gmail.com";
        User user = new User();
        user.setEmail(existingUserEmail);
        user.setPassword("Passw0r!");

        when(userRepository.findByEmail(existingUserEmail)).thenReturn(null);
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userService.addUser(user));
    }
}