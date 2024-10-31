package com.codeinbook.domain.port.in;

import com.codeinbook.common.dto.CategoryDTO;

public interface CategoryServicePort {
    CategoryDTO create(CategoryDTO dto);
}
