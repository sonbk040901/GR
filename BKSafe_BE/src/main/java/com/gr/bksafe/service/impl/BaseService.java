package com.gr.bksafe.service.impl;

import com.gr.bksafe.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 27/10/2023
 * @Time: 02:02
 */
public abstract class BaseService {
    @Autowired
    protected UserDAO userDAO;
}
