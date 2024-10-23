package com.codeinbook.application.adapter.out.repository.mapper;

import com.codeinbook.common.dto.BookDTO;
import com.codeinbook.infrastructure.model.BookModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookModel toModel(BookDTO bookDTO);

    BookDTO toDto(BookModel bookModel);

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
}
