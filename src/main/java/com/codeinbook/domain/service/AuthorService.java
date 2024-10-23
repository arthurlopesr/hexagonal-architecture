package com.codeinbook.domain.service;

import com.codeinbook.common.dto.AuthorDTO;
import com.codeinbook.domain.port.in.AuthorServicePort;
import com.codeinbook.domain.port.out.AuthorRepositoryPort;

public class AuthorService implements AuthorServicePort {

    private final AuthorRepositoryPort authorRepository;

    public AuthorService(AuthorRepositoryPort authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO create(AuthorDTO authorDTO) {
        return authorRepository.create(authorDTO);
    }
}
