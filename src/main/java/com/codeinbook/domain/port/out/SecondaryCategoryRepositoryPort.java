package com.codeinbook.domain.port.out;

import com.codeinbook.common.dto.SecondaryCategoryDTO;

public interface SecondaryCategoryRepositoryPort {
    SecondaryCategoryDTO create(SecondaryCategoryDTO dto);
}
