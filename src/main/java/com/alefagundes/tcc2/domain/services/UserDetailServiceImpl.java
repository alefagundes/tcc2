package com.alefagundes.tcc2.domain.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alefagundes.tcc2.api.controllers.UserAuthenticated;
import com.alefagundes.tcc2.domain.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByNome(username).map(UserAuthenticated::new)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
