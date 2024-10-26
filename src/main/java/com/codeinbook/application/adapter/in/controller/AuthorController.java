package com.codeinbook.application.adapter.in.controller;

import com.codeinbook.common.dto.AuthorDTO;
import com.codeinbook.common.dto.PageDTO;
import com.codeinbook.domain.port.in.AuthorServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorServicePort authorServicePort;

    public AuthorController(AuthorServicePort authorServicePort) {
        this.authorServicePort = authorServicePort;
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> create(@RequestBody AuthorDTO authorDTO) {
        authorServicePort.create(authorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<PageDTO<AuthorDTO>> findAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        var authors = authorServicePort.findAll(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(authors);
    }

    @DeleteMapping("/{authorId}")
    public void deleteById(@PathVariable("authorId") String authorId) {
        authorServicePort.deleteById(authorId);
        ResponseEntity.status(HttpStatus.NO_CONTENT);
    }
}
