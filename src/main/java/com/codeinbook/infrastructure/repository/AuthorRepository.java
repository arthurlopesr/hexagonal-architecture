package com.codeinbook.infrastructure.repository;

import com.codeinbook.infrastructure.model.AuthorModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<AuthorModel, String> {
}
