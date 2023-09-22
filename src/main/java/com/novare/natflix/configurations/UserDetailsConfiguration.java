package com.novare.natflix.configurations;

import com.novare.natflix.models.User;
import com.novare.natflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Service
public class UserDetailsConfiguration implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getUserByEmail(username);
        if(user==null) throw new UsernameNotFoundException("Invalid credentials");

        GrantedAuthority grantedAuthority = user::getRole;

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getHashedPassword(),
                List.of(grantedAuthority)
        );
    }
}
