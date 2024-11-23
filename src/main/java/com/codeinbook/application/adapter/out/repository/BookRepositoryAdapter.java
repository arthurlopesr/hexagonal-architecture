package com.codeinbook.application.adapter.out.repository;

import com.codeinbook.application.adapter.out.repository.mapper.BookMapper;
import com.codeinbook.common.dto.BookDTO;
import com.codeinbook.common.dto.PageDTO;
import com.codeinbook.common.exception.NotFoundException;
import com.codeinbook.domain.port.out.repository.BookRepositoryPort;
import com.codeinbook.infrastructure.model.BookModel;
import com.codeinbook.infrastructure.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookRepositoryAdapter implements BookRepositoryPort {

    private final BookRepository bookRepository;

    @Override
    public BookDTO create(BookDTO bookDTO) {
        var bookModel = BookMapper.INSTANCE.toModel(bookDTO);
        var bookSaved = bookRepository.save(bookModel);
        return BookMapper.INSTANCE.toDto(bookSaved);
    }

    @Override
    public void update(String bookId, BookDTO bookDTO) {
        BookModel bookModel = getBook(bookId);
        bookModel.with(bookDTO);
        bookRepository.save(bookModel);
    }

    @Override
    public BookDTO findById(String bookId) {
        return bookRepository.findById(bookId)
                .map(BookMapper.INSTANCE::toDto)
                .orElseThrow(() -> new NotFoundException("Book with ID " + bookId + " not found"));
    }

    @Override
    public void delete(String bookId) {
        getBook(bookId);
        bookRepository.deleteById(bookId);
    }

    @Override
    public PageDTO<BookDTO> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<BookModel> bookPage = bookRepository.findAll(pageRequest);
        List<BookDTO> bookList = bookPage.stream()
                .map(BookMapper.INSTANCE::toDto)
                .toList();

        return PageDTO.<BookDTO>builder()
                .content(bookList)
                .page(page)
                .size(size)
                .totalPages(bookPage.getTotalPages())
                .totalElements(bookPage.getTotalElements())
                .build();
    }

    private BookModel getBook(String bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new NotFoundException("Book not found"));
    }
}
