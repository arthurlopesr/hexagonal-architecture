package com.codeinbook.domain.service;

import com.codeinbook.common.dto.AuthorDTO;
import com.codeinbook.common.dto.PageDTO;
import com.codeinbook.domain.port.out.AuthorRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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

    @Test
    @DisplayName("Should return all author with pagination")
    void execute_findAll() {
        List<AuthorDTO> authorDTOList = List.of(authorDTO);
        PageDTO<AuthorDTO> page = PageDTO.<AuthorDTO>builder()
                .content(authorDTOList)
                .page(0)
                .size(10)
                .totalElements(100)
                .totalPages(10)
                .build();

        when(authorRepositoryPort.findAll(0, 10)).thenReturn(page);
        assertEquals(page, authorService.findAll(0, 10));
    }
}