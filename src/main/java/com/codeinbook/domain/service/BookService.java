package com.codeinbook.domain.service;

import com.codeinbook.common.dto.BookDTO;
import com.codeinbook.common.dto.CategoryBookEventDTO;
import com.codeinbook.common.dto.PageDTO;
import com.codeinbook.domain.port.in.BookServicePort;
import com.codeinbook.domain.port.out.repository.BookRepositoryPort;

import java.util.List;

public class BookService implements BookServicePort {

    private final BookRepositoryPort bookRepositoryPort;

    public BookService(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    public BookDTO create(BookDTO dto) {
        return bookRepositoryPort.create(dto);
    }

    public void update(String bookId, BookDTO bookDTO) {
        bookRepositoryPort.update(bookId, bookDTO);
    }

    public BookDTO findById(String bookId) {
        return bookRepositoryPort.findById(bookId);
    }

    public void deleteById(String bookId) {
        bookRepositoryPort.delete(bookId);
    }

    public PageDTO<BookDTO> findAll(int page, int size) {
        return bookRepositoryPort.findAll(page, size);
    }

    @Override
    public void updateAllCategoriesId(CategoryBookEventDTO eventDTO) {
        List<BookDTO> bookList = bookRepositoryPort.findAllByCategoryId(eventDTO.source());
        bookList.forEach(book -> {
            bookRepositoryPort.update(book.bookId(), book);
        });
    }
}
