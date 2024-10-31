package com.codeinbook.application.adapter.out.repository;

import com.codeinbook.application.adapter.out.repository.mapper.CategoryMapper;
import com.codeinbook.common.dto.CategoryDTO;
import com.codeinbook.domain.port.out.CategoryRepositoryPort;
import com.codeinbook.infrastructure.model.CategoryModel;
import com.codeinbook.infrastructure.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<CategoryDTO> findAllCategories() {
        var categoryList = categoryRepository.findAll();

        return categoryList.stream()
                .map(CategoryMapper.INSTANCE::toDto)
                .toList();
    }

    @Override
    public void deleteById(String categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
