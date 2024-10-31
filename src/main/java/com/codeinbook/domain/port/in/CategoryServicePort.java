package com.codeinbook.domain.port.in;

import com.codeinbook.common.dto.CategoryDTO;

import java.util.List;

public interface CategoryServicePort {
    CategoryDTO create(CategoryDTO dto);

    List<CategoryDTO> findAllCategories();

    void deleteById(String categoryId);
}
