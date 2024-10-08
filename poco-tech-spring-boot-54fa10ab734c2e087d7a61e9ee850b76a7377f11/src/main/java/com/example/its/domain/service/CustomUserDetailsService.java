package com.example.its.domain.service;

import com.example.its.domain.model.Users;
import com.example.its.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> userOptional = userRepository.findByUsernameAndDeleteflagFalse(username);
        Users users = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Get the authority as a String directly
        String authority = users.getAuthority();

        return new org.springframework.security.core.userdetails.User(
                users.getUsername(),
                users.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(authority)) // Use String authority
        );
    }

    private List<GrantedAuthority> toGrantedAuthorityList(String authority) {
        // Convert String authority directly
        return Collections.singletonList(new SimpleGrantedAuthority(authority));
    }
}
