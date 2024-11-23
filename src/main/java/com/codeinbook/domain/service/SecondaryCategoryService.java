package com.codeinbook.domain.service;

import com.codeinbook.common.dto.SecondaryCategoryDTO;
import com.codeinbook.domain.port.in.SecondaryCategoryServicePort;
import com.codeinbook.domain.port.out.repository.SecondaryCategoryRepositoryPort;

public class SecondaryCategoryService implements SecondaryCategoryServicePort {

    private final SecondaryCategoryRepositoryPort secondaryCategoryRepositoryPort;

    public SecondaryCategoryService(SecondaryCategoryRepositoryPort secondaryCategoryRepositoryPort) {
        this.secondaryCategoryRepositoryPort = secondaryCategoryRepositoryPort;
    }

    public SecondaryCategoryDTO create(SecondaryCategoryDTO secondaryCategoryDTO) {
        return secondaryCategoryRepositoryPort.create(secondaryCategoryDTO);
    }
}
