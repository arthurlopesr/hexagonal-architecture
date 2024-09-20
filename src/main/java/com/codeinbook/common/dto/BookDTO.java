package com.codeinbook.common.dto;

import java.math.BigDecimal;

public record BookDTO(
        String bookId,
        String title,
        String subtitle,
        String description,
        BigDecimal price
) {
}
