package com.codeinbook.domain.port.in;

import com.codeinbook.common.dto.AuthorDTO;

public interface AuthorServicePort {

    AuthorDTO create(AuthorDTO authorDTO);
}
