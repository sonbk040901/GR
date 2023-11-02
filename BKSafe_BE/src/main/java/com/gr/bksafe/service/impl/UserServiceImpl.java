package com.gr.bksafe.service.impl;

import com.gr.bksafe.service.UserService;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 30/10/2023
 * @Time: 17:19
 */
@Service
public class UserServiceImpl extends BaseService implements UserService, UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByEmail(username)
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    static class CustomUserDetails extends User {
        public CustomUserDetails(@NonNull com.gr.bksafe.entity.User user) {
            super(user.getEmail(), user.getPassword(), extractAuthorities(user.getRole().name()));
        }

        private static Collection<? extends GrantedAuthority> extractAuthorities(String value) {
            return Collections.singleton(new SimpleGrantedAuthority(value));
        }
    }
}
