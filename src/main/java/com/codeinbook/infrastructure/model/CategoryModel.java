package com.codeinbook.infrastructure.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CategoryModel {

    public CategoryModel(String categoryId, String name, String categoryType) {
        this.categoryId = categoryId;
        this.name = name;
        this.categoryType = categoryType;
    }

    @Id
    private String categoryId;

    private final String name;

    private final String categoryType;

    public String getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getCategoryType() {
        return categoryType;
    }
}
