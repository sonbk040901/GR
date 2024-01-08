package com.gr.bksafe.handler.exception;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 24/12/2023
 * @Time: 19:15
 */
@RequiredArgsConstructor
@Getter
@Setter
public class CustomException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;
}
