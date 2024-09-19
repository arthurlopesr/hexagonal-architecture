package com.codeinbook.application.adapter.out;

import com.codeinbook.common.dto.BookDTO;
import com.codeinbook.common.dto.PageDTO;
import com.codeinbook.domain.port.out.BookRepositoryPort;
import com.codeinbook.infrastructure.repository.BookRepository;

public class BookRepositoryAdapter implements BookRepositoryPort {

    private BookRepository bookRepository;

    @Override
    public BookDTO create(BookDTO bookDTO) {
        return null;
    }

    @Override
    public void update(String number, BookDTO bookDTO) {

    }

    @Override
    public BookDTO findById(String number) {
        return null;
    }

    @Override
    public void delete(String bookId) {

    }

    @Override
    public PageDTO<BookDTO> findAll(int page, int size) {
        return null;
    }
}
