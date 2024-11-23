package com.codeinbook.domain.port.out.repository;

import com.codeinbook.common.dto.BookDTO;
import com.codeinbook.common.dto.PageDTO;

public interface BookRepositoryPort {

    BookDTO create(BookDTO bookDTO);

    void update(String number, BookDTO bookDTO);

    BookDTO findById(String number);

    void delete(String bookId);

    PageDTO<BookDTO> findAll(int page, int size);
}