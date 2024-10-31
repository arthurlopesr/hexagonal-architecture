package com.codeinbook.application.adapter.out.repository;

import com.codeinbook.application.adapter.out.repository.mapper.CategoryMapper;
import com.codeinbook.common.dto.CategoryDTO;
import com.codeinbook.domain.port.out.CategoryRepositoryPort;
import com.codeinbook.infrastructure.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepositoryAdapter implements CategoryRepositoryPort {

    private final CategoryRepository categoryRepository;

    public CategoryRepositoryAdapter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        var categoryModel = CategoryMapper.INSTANCE.toModel(categoryDTO);
        var categorySaved = categoryRepository.save(categoryModel);
        return CategoryMapper.INSTANCE.toDto(categorySaved);
    }
}
