package com.gr.bksafe.handler.exception;

import org.springframework.http.HttpStatus;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 24/12/2023
 * @Time: 19:23
 */
public class UserAlreadyExistException extends CustomException {
    public UserAlreadyExistException() {
        this("User already exist");
    }

    public UserAlreadyExistException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}