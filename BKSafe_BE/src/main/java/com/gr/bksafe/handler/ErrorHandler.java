package com.gr.bksafe.handler;

import com.gr.bksafe.dto.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 02/11/2023
 * @Time: 14:45
 */
@RestControllerAdvice
@Slf4j
public class ErrorHandler {
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> handleException(Throwable throwable) {
        log.error("Error: ", throwable);
        return Response.builder()
                .message(throwable.getMessage())
                .build();
    }
}
