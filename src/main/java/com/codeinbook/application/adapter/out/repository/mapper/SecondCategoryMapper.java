package com.codeinbook.application.adapter.out.repository.mapper;

import com.codeinbook.common.dto.SecondaryCategoryDTO;
import com.codeinbook.infrastructure.model.SecondCategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SecondCategoryMapper {

    SecondCategoryModel toModel(SecondaryCategoryDTO secondCategoryDTO);

    SecondaryCategoryDTO toDto(SecondCategoryModel secondCategoryModel);

    SecondCategoryMapper INSTANCE = Mappers.getMapper(SecondCategoryMapper.class);
}
