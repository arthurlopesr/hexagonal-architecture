package com.codeinbook.common.dto;

import lombok.Builder;

@Builder
public record CategoryDTO(
        String categoryId,
        String name,
        String categoryType
) {
}
