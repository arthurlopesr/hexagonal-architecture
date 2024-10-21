package com.codeinbook.common.exception.handler;

import com.codeinbook.common.dto.ErrorResponseDTO;
import com.codeinbook.common.exception.BadRequestException;
import com.codeinbook.common.exception.BusinessException;
import com.codeinbook.common.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> notFoundException(NotFoundException notFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponseDTO.builder()
                .message(notFoundException.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .httpStatus(HttpStatus.NOT_FOUND)
                .source(notFoundException.getClass().getName())
                .build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDTO> badRequestException(BadRequestException badRequestException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDTO.builder()
                .message(badRequestException.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .source(badRequestException.getClass().getName())
                .build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDTO> businessException(BusinessException businessException) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorResponseDTO.builder()
                .message(businessException.getMessage())
                .statusCode(HttpStatus.CONFLICT.value())
                .httpStatus(HttpStatus.CONFLICT)
                .source(businessException.getClass().getName())
                .build());
    }
}
