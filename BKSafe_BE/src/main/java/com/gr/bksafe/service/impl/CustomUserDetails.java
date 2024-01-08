package com.gr.bksafe.service.impl;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 24/12/2023
 * @Time: 17:36
 */
public class CustomUserDetails extends User{
    public CustomUserDetails(@NonNull com.gr.bksafe.entity.User user) {
        super(user.getEmail(), user.getPassword(), extractAuthorities(user.getRole().name()));
    }

    private static Collection<? extends GrantedAuthority> extractAuthorities(String value) {
        return Collections.singleton(new SimpleGrantedAuthority(value));
    }
}
