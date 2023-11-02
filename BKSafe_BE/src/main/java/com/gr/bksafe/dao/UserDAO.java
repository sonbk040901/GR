package com.gr.bksafe.dao;

import com.gr.bksafe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 29/10/2023
 * @Time: 21:48
 */
public interface UserDAO extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
