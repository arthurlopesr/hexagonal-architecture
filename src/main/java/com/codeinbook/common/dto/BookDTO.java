package com.codeinbook.common.dto;

import java.math.BigDecimal;

public record BookDTO(
        String bookId,
        String title,
        String subTitle,
        String description,
        BigDecimal price
) {
}
