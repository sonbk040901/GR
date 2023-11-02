package com.gr.bksafe.dao;

import com.gr.bksafe.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 02/11/2023
 * @Time: 14:36
 */
public interface DriverDAO extends JpaRepository<Driver, Integer> {
}
