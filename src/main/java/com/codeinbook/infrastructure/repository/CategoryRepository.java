package com.codeinbook.infrastructure.repository;

import com.codeinbook.infrastructure.model.CategoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<CategoryModel, String> {
}
