package com.codeinbook.infrastructure.model;

import com.codeinbook.application.enums.CategoryTypeEnum;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document
public class SecondCategoryModel {

    public SecondCategoryModel(String secondaryCategoryId, String name, String primaryCategoryId, CategoryTypeEnum categoryType) {
        this.secondaryCategoryId = secondaryCategoryId;
        this.name = name;
        this.primaryCategoryId = primaryCategoryId;
        this.categoryType = categoryType;
    }

    @Id
    private final String secondaryCategoryId;
    private final String name;
    private final String primaryCategoryId;
    private final CategoryTypeEnum categoryType;
}
