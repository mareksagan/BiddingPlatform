package com.biddingplatform.db.services;

import com.biddingplatform.db.DAOs.UserDAO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UserDAO users;

    public CustomUserDetailsService(UserDAO users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.users.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + email + " not found"));
    }
}
