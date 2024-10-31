package com.codeinbook.domain.service;

import com.codeinbook.common.dto.CategoryDTO;
import com.codeinbook.domain.port.in.CategoryServicePort;
import com.codeinbook.domain.port.out.CategoryRepositoryPort;

import java.util.List;

public class CategoryService implements CategoryServicePort {

    private final CategoryRepositoryPort categoryRepositoryPort;

    public CategoryService(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    public CategoryDTO create(CategoryDTO dto) {
        return categoryRepositoryPort.create(dto);
    }

    @Override
    public List<CategoryDTO> findAllCategories() {
        return categoryRepositoryPort.findAllCategories();
    }
}
