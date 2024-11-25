package com.codeinbook.domain.port.in;

import com.codeinbook.common.dto.BookDTO;
import com.codeinbook.common.dto.CategoryBookEventDTO;
import com.codeinbook.common.dto.PageDTO;

public interface BookServicePort {
    BookDTO create(BookDTO dto);

    void update(String bookId, BookDTO bookDTO);

    BookDTO findById(String bookId);

    void deleteById(String bookId);

    PageDTO<BookDTO> findAll(int page, int size);

    void updateAllCategoriesId(CategoryBookEventDTO eventDTO);
}
