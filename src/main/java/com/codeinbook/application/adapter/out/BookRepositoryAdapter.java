package com.codeinbook.application.adapter.out;

import com.codeinbook.application.adapter.out.mapper.BookMapper;
import com.codeinbook.common.dto.BookDTO;
import com.codeinbook.common.dto.PageDTO;
import com.codeinbook.common.exception.NotFoundException;
import com.codeinbook.domain.port.out.BookRepositoryPort;
import com.codeinbook.infrastructure.model.BookModel;
import com.codeinbook.infrastructure.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookRepositoryAdapter implements BookRepositoryPort {
    private BookRepository bookRepository;

    @Override
    public BookDTO create(BookDTO bookDTO) {
        var bookModel = BookMapper.INSTANCE.toModel(bookDTO);
        var bookSaved = bookRepository.save(bookModel);
        return BookMapper.INSTANCE.toDto(bookSaved);
    }

    @Override
    public void update(String number, BookDTO bookDTO) {

    }

    @Override
    public BookDTO findById(String bookId) {
        return bookRepository.findById(bookId)
                .map(BookMapper.INSTANCE::toDto)
                .orElseThrow(() -> new NotFoundException("Book with ID " + bookId + " not found"));
    }

    @Override
    public void delete(String bookId) {

    }

    @Override
    public PageDTO<BookDTO> findAll(int page, int size) {
        return null;
    }
}
