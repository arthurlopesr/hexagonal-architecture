package com.codeinbook.application.adapter.out.repository.mapper;

import com.codeinbook.common.dto.CategoryDTO;
import com.codeinbook.infrastructure.model.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryModel toModel(CategoryDTO categoryDTO);

    CategoryDTO toDto(CategoryModel categoryModel);

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
}
