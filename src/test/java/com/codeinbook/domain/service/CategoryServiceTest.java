package com.codeinbook.domain.service;

import com.codeinbook.common.dto.CategoryDTO;
import com.codeinbook.domain.port.out.CategoryRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @InjectMocks
    CategoryService categoryService;

    @Mock
    CategoryRepositoryPort categoryRepositoryPort;

    CategoryDTO categoryDTO;

    @BeforeEach
    void setUp() {
        categoryDTO = CategoryDTO.builder()
                .categoryId("any_id")
                .name("any_category_name")
                .categoryType("any_category_type")
                .build();
    }

    @Test
    @DisplayName("Should create new category")
    void execute_create() {
        when(categoryService.create(categoryDTO)).thenReturn(categoryDTO);

        assertEquals(categoryDTO, categoryService.create(categoryDTO));
        verify(categoryRepositoryPort, times(1)).create(categoryDTO);
    }
}