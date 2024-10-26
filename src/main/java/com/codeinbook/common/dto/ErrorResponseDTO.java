package com.codeinbook.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@Data
public class ErrorResponseDTO {
    private String message;
    private HttpStatus httpStatus;
    private Integer statusCode;
    private String source;
}