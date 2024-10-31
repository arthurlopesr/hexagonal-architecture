package com.codeinbook.domain.port.out;

import com.codeinbook.common.dto.CategoryDTO;

import java.util.List;

public interface CategoryRepositoryPort {

    CategoryDTO create(CategoryDTO dto);

    List<CategoryDTO> findAllCategories();
}
