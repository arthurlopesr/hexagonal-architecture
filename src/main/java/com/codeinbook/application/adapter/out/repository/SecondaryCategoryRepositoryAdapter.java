package com.codeinbook.application.adapter.out.repository;

import com.codeinbook.application.adapter.out.repository.mapper.SecondCategoryMapper;
import com.codeinbook.common.dto.SecondaryCategoryDTO;
import com.codeinbook.domain.port.out.repository.SecondaryCategoryRepositoryPort;
import com.codeinbook.infrastructure.repository.CategoryRepository;
import com.codeinbook.infrastructure.repository.SecondCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@RequiredArgsConstructor
public class SecondaryCategoryRepositoryAdapter implements SecondaryCategoryRepositoryPort {

    private final SecondCategoryRepository secondCategoryRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public SecondaryCategoryDTO create(SecondaryCategoryDTO secondCategoryDTO) {
        var primary = categoryRepository.findById(secondCategoryDTO.primaryCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        var secondCategoryModel = SecondCategoryMapper.INSTANCE.toModel(secondCategoryDTO);
        var secondCategorySaved = secondCategoryRepository.save(secondCategoryModel);

        primary.initializeSecondaryCategoriesIfNeeded();
        primary.getSecondaryCategories().add(secondCategorySaved);

        categoryRepository.save(primary);
        return SecondCategoryMapper.INSTANCE.toDto(secondCategorySaved);
    }
}
