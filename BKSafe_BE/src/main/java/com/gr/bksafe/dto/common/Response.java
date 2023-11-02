package com.gr.bksafe.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 02/11/2023
 * @Time: 14:51
 */
@Builder
public record Response<T>(boolean success, String message,
                          T data) {
}
