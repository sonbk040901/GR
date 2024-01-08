package com.gr.bksafe.handler;

import com.gr.bksafe.dto.common.Response;
import com.gr.bksafe.handler.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 02/11/2023
 * @Time: 14:45
 */
@RestControllerAdvice
@Slf4j
public class ErrorHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Response<?>> handleCustomException(CustomException customException) {
        log.error("Error: ", customException);
        return ResponseEntity.status(customException.getHttpStatus())
                .body(Response.builder()
                        .message(customException.getMessage())
                        .build());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> handleException(Throwable throwable) {
        log.error("Error: ", throwable);
        return Response.builder()
                .message(throwable.getMessage())
                .build();
    }
}
