package com.codeinbook.infrastructure.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Document
public class CategoryModel {

    public CategoryModel(String categoryId, String name, String categoryType, List<CategoryModel> secondaryCategories) {
        this.categoryId = categoryId;
        this.name = name;
        this.categoryType = categoryType;
        this.secondaryCategories = secondaryCategories;
    }

    @Id
    private String categoryId;

    private final String name;

    private final String categoryType;

    private final List<CategoryModel> secondaryCategories;
}
