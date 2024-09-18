package com.codeinbook.domain.service;

import com.codeinbook.common.dto.BookDTO;
import com.codeinbook.domain.port.out.BookRepositoryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepositoryPort bookRepositoryPort;

    BookDTO bookDTO;

    @BeforeEach
    void setUp() {
        bookDTO = new BookDTO("1",
                "any_title",
                "any_subtilte",
                "any_description",
                BigDecimal.valueOf(29.90));
    }

    @Test
    @DisplayName("Should create new book")
    void shouldCreateNewBook() {
        when(bookRepositoryPort.create(bookDTO)).thenReturn(bookDTO);
        assertEquals(bookDTO, bookService.create(bookDTO));

        verify(bookRepositoryPort, times(1)).create(bookDTO);
    }

    @Test
    @DisplayName("Should update book")
    void updateBook() {
        bookService.update("1", bookDTO);

        verify(bookRepositoryPort, times(1)).update("1", bookDTO);
    }

    @Test
    @DisplayName("Should get book by id")
    void shouldGetBookById() {
        when(bookRepositoryPort.findById("1")).thenReturn(bookDTO);
        assertEquals(bookDTO, bookService.findById("1"));

        verify(bookRepositoryPort, times(1)).findById("1");
    }

    @Test
    @DisplayName("Should delete book")
    void deleteBook() {
        bookService.delete("1");

        verify(bookRepositoryPort, times(1)).delete("1");
    }
}