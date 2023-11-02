package com.gr.bksafe.dao;

import com.gr.bksafe.entity.Location;
import com.gr.bksafe.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 02/11/2023
 * @Time: 13:27
 */
public interface RequestDAO extends JpaRepository<Request, Integer> {
}
