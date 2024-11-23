package com.codeinbook.domain.service;

import com.codeinbook.application.enums.CategoryTypeEnum;
import com.codeinbook.common.dto.CategoryBookEventDTO;
import com.codeinbook.common.dto.CategoryDTO;
import com.codeinbook.domain.port.in.CategoryServicePort;
import com.codeinbook.domain.port.out.producer.EventProducerPort;
import com.codeinbook.domain.port.out.repository.CategoryRepositoryPort;

import java.util.List;

public class CategoryService implements CategoryServicePort {

    private final CategoryRepositoryPort categoryRepositoryPort;
    private final EventProducerPort eventProducerPort;

    public CategoryService(CategoryRepositoryPort categoryRepositoryPort, EventProducerPort eventProducerPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
        this.eventProducerPort = eventProducerPort;
    }

    public CategoryDTO create(CategoryDTO dto) {
        return categoryRepositoryPort.create(dto);
    }

    @Override
    public List<CategoryDTO> findAllCategories() {
        return categoryRepositoryPort.findAllCategories();
    }

    @Override
    public void deleteById(String categoryId) {
        var categoryEvent = buildCategoryBookEventDTO(categoryId);
        categoryRepositoryPort.deleteById(categoryId);
        eventProducerPort.updateCategoryBook(categoryEvent);
    }

    private CategoryBookEventDTO buildCategoryBookEventDTO(String categoryId) {
        return CategoryBookEventDTO.builder()
                .source(categoryId)
                .target(CategoryTypeEnum.PRIMARY.name())
                .build();
    }
}
