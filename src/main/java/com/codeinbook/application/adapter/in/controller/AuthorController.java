package com.codeinbook.application.adapter.in.controller;

import com.codeinbook.common.dto.AuthorDTO;
import com.codeinbook.domain.port.in.AuthorServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorServicePort authorServicePort;

    public AuthorController(AuthorServicePort authorServicePort) {
        this.authorServicePort = authorServicePort;
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> create(@RequestBody AuthorDTO authorDTO) {
        authorServicePort.create(authorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
