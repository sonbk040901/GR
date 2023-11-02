package com.gr.bksafe.dao;

import com.gr.bksafe.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 29/10/2023
 * @Time: 21:50
 */
public interface CarDAO extends JpaRepository<Car, Integer> {
}
