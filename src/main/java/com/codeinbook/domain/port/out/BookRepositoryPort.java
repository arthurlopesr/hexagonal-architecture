package com.codeinbook.domain.port.out;

import com.codeinbook.common.dto.BookDTO;

public interface BookRepositoryPort {

    BookDTO create(BookDTO bookDTO);

    void update(String number, BookDTO bookDTO);

    BookDTO findById(String number);

    void delete(String bookId);
}