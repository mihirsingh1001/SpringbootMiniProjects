package com.project.usermodule.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.usermodule.entities.CustomUserDetails;
import com.project.usermodule.entities.Users;
import com.project.usermodule.repository.UserRepository;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not Found :: " + username));
        return new CustomUserDetails(user);
    }

}
