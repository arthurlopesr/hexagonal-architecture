package com.codeinbook.domain.port.out;

import com.codeinbook.common.dto.AuthorDTO;

public interface AuthorRepositoryPort {

    AuthorDTO create(AuthorDTO authorDTO);
}
