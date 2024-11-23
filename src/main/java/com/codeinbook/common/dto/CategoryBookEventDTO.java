package com.codeinbook.common.dto;

import lombok.Builder;

@Builder
public record CategoryBookEventDTO(
        String source,
        String target
) {
}
