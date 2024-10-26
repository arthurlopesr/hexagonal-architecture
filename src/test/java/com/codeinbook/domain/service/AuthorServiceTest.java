package com.codeinbook.domain.service;

import com.codeinbook.common.dto.AuthorDTO;
import com.codeinbook.domain.port.out.AuthorRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @InjectMocks
    AuthorService authorService;

    @Mock
    AuthorRepositoryPort authorRepositoryPort;

    AuthorDTO authorDTO;

    @BeforeEach
    void setUp() {
        authorDTO = AuthorDTO.builder()
                .name("any_name_author")
                .resume("any_resume_author")
                .build();
    }

    @Test
    @DisplayName("Should create book's author")
    void execute_create_author() {
        when(authorService.create(authorDTO)).thenReturn(authorDTO);

        assertEquals(authorDTO, authorService.create(authorDTO));
        verify(authorRepositoryPort, times(1)).create(authorDTO);
    }
}