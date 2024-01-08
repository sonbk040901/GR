package com.gr.bksafe.dto.common;

import lombok.Builder;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 02/11/2023
 * @Time: 14:51
 */
@Builder
public record Response<T>(boolean success, String message, T data) {
    public Record ok() {
        return Response.<T>builder()
                .success(true)
                .message("OK")
                .data(this.data)
                .build();
    }
}
