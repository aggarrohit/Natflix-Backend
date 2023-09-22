package com.novare.natflix.controllers;

import com.novare.natflix.dtos.UserDto;
import com.novare.natflix.mappers.UserMapper;
import com.novare.natflix.models.User;
import com.novare.natflix.services.UserService;
import com.novare.natflix.utilities.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenUtil jwtTokenUtil;


    @PostMapping()
    public ResponseEntity<UserDto> login(@RequestBody @Valid User request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getEmail(), request.getPassword()
                            )
                    );

            UserDetails userDetails = (UserDetails) authenticate.getPrincipal();

            User user;
            if(userDetails!=null){
                user = userService.getUserByEmail(userDetails.getUsername());


            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.AUTHORIZATION,
                            jwtTokenUtil.generateToken(userDetails)
                    )
                    .body(UserMapper.toUserDto(user));
            }else{
                throw new BadCredentialsException("invalid user");
            }
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
