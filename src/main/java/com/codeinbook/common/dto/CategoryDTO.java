package com.codeinbook.common.dto;

import com.codeinbook.application.enums.CategoryTypeEnum;
import lombok.Builder;

import java.util.List;

@Builder
public record CategoryDTO(
        String categoryId,
        String name,
        CategoryTypeEnum categoryType,
        List<SecondaryCategoryDTO> secondaryCategories
) {
}
