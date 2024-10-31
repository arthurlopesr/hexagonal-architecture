package com.codeinbook.application.adapter.configuration;

import com.codeinbook.domain.port.out.AuthorRepositoryPort;
import com.codeinbook.domain.port.out.BookRepositoryPort;
import com.codeinbook.domain.port.out.CategoryRepositoryPort;
import com.codeinbook.domain.port.out.SecondaryCategoryRepositoryPort;
import com.codeinbook.domain.service.AuthorService;
import com.codeinbook.domain.service.BookService;
import com.codeinbook.domain.service.CategoryService;
import com.codeinbook.domain.service.SecondaryCategoryService;
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

    @Bean
    public CategoryService categoryService(CategoryRepositoryPort categoryRepositoryPort) {
        return new CategoryService(categoryRepositoryPort);
    }

    @Bean
    public SecondaryCategoryService secondaryCategoryService(SecondaryCategoryRepositoryPort secondaryCategoryRepositoryPort) {
        return new SecondaryCategoryService(secondaryCategoryRepositoryPort);
    }
}
