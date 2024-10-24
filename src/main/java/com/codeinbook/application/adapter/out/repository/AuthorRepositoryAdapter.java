package com.codeinbook.application.adapter.out.repository;

import com.codeinbook.application.adapter.out.repository.mapper.AuthorMapper;
import com.codeinbook.common.dto.AuthorDTO;
import com.codeinbook.domain.port.out.AuthorRepositoryPort;
import com.codeinbook.infrastructure.repository.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class AuthorRepositoryAdapter implements AuthorRepositoryPort {

    private final AuthorRepository authorRepository;

    public AuthorRepositoryAdapter(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDTO create(AuthorDTO authorDTO) {
        var authorModel = AuthorMapper.INSTANCE.toModel(authorDTO);
        var authorSaved = authorRepository.save(authorModel);
        return AuthorMapper.INSTANCE.toDto(authorSaved);
    }
}
