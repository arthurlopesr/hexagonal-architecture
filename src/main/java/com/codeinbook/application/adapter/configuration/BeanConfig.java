package com.codeinbook.application.adapter.configuration;

import com.codeinbook.domain.port.in.AuthorServicePort;
import com.codeinbook.domain.port.out.AuthorRepositoryPort;
import com.codeinbook.domain.port.out.BookRepositoryPort;
import com.codeinbook.domain.service.AuthorService;
import com.codeinbook.domain.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public BookService bookService(BookRepositoryPort bookRepositoryPort) {
        return new BookService(bookRepositoryPort);
    }

    @Bean
    public AuthorService authorService(AuthorRepositoryPort authorRepositoryPort) {
        return new AuthorService(authorRepositoryPort);
    }
}
