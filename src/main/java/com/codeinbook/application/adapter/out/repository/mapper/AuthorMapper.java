package com.codeinbook.application.adapter.out.repository.mapper;

import com.codeinbook.common.dto.AuthorDTO;
import com.codeinbook.infrastructure.model.AuthorModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorModel toModel(AuthorDTO authorDTO);

    AuthorDTO toDto(AuthorModel authorModel);

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
}
