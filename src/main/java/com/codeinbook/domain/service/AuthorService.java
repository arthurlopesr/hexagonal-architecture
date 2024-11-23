package com.codeinbook.domain.service;

import com.codeinbook.common.dto.AuthorDTO;
import com.codeinbook.common.dto.PageDTO;
import com.codeinbook.domain.port.in.AuthorServicePort;
import com.codeinbook.domain.port.out.repository.AuthorRepositoryPort;

public class AuthorService implements AuthorServicePort {

    private final AuthorRepositoryPort authorRepository;

    public AuthorService(AuthorRepositoryPort authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO create(AuthorDTO authorDTO) {
        return authorRepository.create(authorDTO);
    }

    public PageDTO<AuthorDTO> findAll(int page, int size) {
        return authorRepository.findAll(page, size);
    }

    public void deleteById(String authorId) {
        authorRepository.deleteById(authorId);
    }
}
