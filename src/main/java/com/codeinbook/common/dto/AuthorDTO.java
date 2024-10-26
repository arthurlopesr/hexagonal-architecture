package com.codeinbook.common.dto;

import lombok.Builder;

@Builder
public record AuthorDTO(
        String name,
        String resume
) {
}
