package com.codeinbook.domain.port.out.repository;

import com.codeinbook.common.dto.CategoryDTO;

import java.util.List;

public interface CategoryRepositoryPort {

    CategoryDTO create(CategoryDTO dto);

    List<CategoryDTO> findAllCategories();

    void deleteById(String categoryId);
}
