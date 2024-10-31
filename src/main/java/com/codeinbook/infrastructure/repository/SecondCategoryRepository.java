package com.codeinbook.infrastructure.repository;

import com.codeinbook.infrastructure.model.SecondCategoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondCategoryRepository extends MongoRepository<SecondCategoryModel, String> {
}
