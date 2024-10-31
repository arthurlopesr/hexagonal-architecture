package com.codeinbook.infrastructure.model;

import com.codeinbook.application.enums.CategoryTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document
public class CategoryModel {

    public CategoryModel(String categoryId, String name, CategoryTypeEnum categoryType, List<SecondCategoryModel> secondaryCategories) {
        this.categoryId = categoryId;
        this.name = name;
        this.categoryType = categoryType;
        this.secondaryCategories = secondaryCategories;
    }

    @Id
    private String categoryId;

    private final String name;

    private final CategoryTypeEnum categoryType;

    private List<SecondCategoryModel> secondaryCategories;

    public void initializeSecondaryCategoriesIfNeeded() {
        if (secondaryCategories == null) {
            secondaryCategories = new ArrayList<>();
        }
    }
}
