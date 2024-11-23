package com.codeinbook.application.adapter.out.repository;

import com.codeinbook.application.adapter.out.repository.mapper.AuthorMapper;
import com.codeinbook.common.dto.AuthorDTO;
import com.codeinbook.common.dto.PageDTO;
import com.codeinbook.domain.port.out.repository.AuthorRepositoryPort;
import com.codeinbook.infrastructure.model.AuthorModel;
import com.codeinbook.infrastructure.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorRepositoryAdapter implements AuthorRepositoryPort {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorDTO create(AuthorDTO authorDTO) {
        var authorModel = AuthorMapper.INSTANCE.toModel(authorDTO);
        var authorSaved = authorRepository.save(authorModel);
        return AuthorMapper.INSTANCE.toDto(authorSaved);
    }

    @Override
    public PageDTO<AuthorDTO> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<AuthorModel> authorPage = authorRepository.findAll(pageRequest);
        List<AuthorDTO> authorList = authorPage.stream()
                .map(AuthorMapper.INSTANCE::toDto)
                .toList();

        return PageDTO.<AuthorDTO>builder()
                .content(authorList)
                .page(page)
                .size(size)
                .totalElements(authorPage.getTotalElements())
                .totalPages(authorPage.getTotalPages())
                .build();
    }

    @Override
    public void deleteById(String authorId) {
        authorRepository.deleteById(authorId);
    }
}
