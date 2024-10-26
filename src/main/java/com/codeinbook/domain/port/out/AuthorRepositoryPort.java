package com.codeinbook.domain.port.out;

import com.codeinbook.common.dto.AuthorDTO;
import com.codeinbook.common.dto.PageDTO;

public interface AuthorRepositoryPort {

    AuthorDTO create(AuthorDTO authorDTO);
    PageDTO<AuthorDTO> findAll(int page, int size);
    void deleteById(String authorId);
}
