package com.codeinbook.infrastructure.repository;

import com.codeinbook.infrastructure.model.BookModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<BookModel, String> {
}
