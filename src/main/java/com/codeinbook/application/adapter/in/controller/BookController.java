package com.codeinbook.application.adapter.in.controller;

import com.codeinbook.common.dto.BookDTO;
import com.codeinbook.common.dto.PageDTO;
import com.codeinbook.common.exception.BadRequestException;
import com.codeinbook.domain.port.in.BookServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookServicePort bookServicePort;

    public BookController(BookServicePort bookServicePort) {
        this.bookServicePort = bookServicePort;
    }

    @PostMapping
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO) {
        if (bookDTO.title() == null || bookDTO.title().isEmpty()) {
            throw new BadRequestException("Title not found");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(bookServicePort.create(bookDTO));
    }

    @PatchMapping("/{bookId}")
    public void update(@RequestBody BookDTO bookDTO, @PathVariable("bookId") String bookId) {
        bookServicePort.update(bookId, bookDTO);
        ResponseEntity.noContent();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDTO> findById(@PathVariable("bookId") String bookId) {
        return ResponseEntity.status(HttpStatus.OK).body(bookServicePort.findById(bookId));
    }

    @GetMapping
    public ResponseEntity<PageDTO<BookDTO>> findAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        return ResponseEntity.status(HttpStatus.OK).body(bookServicePort.findAll(page, size));
    }

    @DeleteMapping("/{bookId}")
    public void deleteById(@PathVariable("bookId") String bookId) {
        bookServicePort.deleteById(bookId);
        ResponseEntity.noContent();
    }
}
