package com.novare.natflix.services;

import com.novare.natflix.exceptions.UserAlreadyExistException;
import com.novare.natflix.exceptions.UserNotFoundException;
import com.novare.natflix.models.User;
import com.novare.natflix.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserByEmail(String email){
        User user = userRepository.findByEmail(email);
        if(user==null) throw new UserNotFoundException("email : "+email);
        return user;
    }

    public User addUser(@Valid User user){
        User searchedUser = userRepository.findByEmail(user.getEmail());
        if(searchedUser!=null){
            throw new UserAlreadyExistException("User already exists!! Please login..");
        }else{
            user.setRole("ROLE_CUSTOMER");
            user.setHashedPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }

    }

    public void addAdmin() {
        String adminEmail = "admin_new@natflix.com";
        String adminPassword = "Passw0r!";
        User searchedUser = userRepository.findByEmail(adminEmail);
        if (searchedUser == null) {
            User user = new User();
            user.setName("Admin");
            user.setEmail(adminEmail);
            user.setRole("ROLE_ADMIN");
            user.setHashedPassword(passwordEncoder.encode(adminPassword));
            userRepository.save(user);
        }

    }

}
