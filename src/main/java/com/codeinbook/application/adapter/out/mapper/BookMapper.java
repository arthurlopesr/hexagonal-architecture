package com.codeinbook.application.adapter.out.mapper;

import com.codeinbook.common.dto.BookDTO;
import com.codeinbook.infrastructure.model.BookModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookModel toModel(BookDTO bookDTO);

    BookDTO toDto(BookModel bookModel);
}
