package com.codeinbook.domain.port.out;

import com.codeinbook.common.dto.CategoryDTO;

public interface CategoryRepositoryPort {

    CategoryDTO create(CategoryDTO dto);
}
