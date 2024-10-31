package com.codeinbook.common.dto;

import com.codeinbook.application.enums.CategoryTypeEnum;

public record SecondaryCategoryDTO(
        String secondaryCategoryId,
        String name,
        String primaryCategoryId,
        CategoryTypeEnum categoryType
) {
}
