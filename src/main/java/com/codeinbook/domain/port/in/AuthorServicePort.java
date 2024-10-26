package com.codeinbook.domain.port.in;

import com.codeinbook.common.dto.AuthorDTO;
import com.codeinbook.common.dto.PageDTO;

public interface AuthorServicePort {

    AuthorDTO create(AuthorDTO authorDTO);

    PageDTO<AuthorDTO> findAll(int page, int size);
}
