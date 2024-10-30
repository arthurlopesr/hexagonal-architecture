package com.codeinbook.infrastructure.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document
public class AuthorModel {

    public AuthorModel(String authorId, String resume, String name) {
        this.authorId = authorId;
        this.resume = resume;
        this.name = name;
    }

    @Id
    private String authorId;

    private final String name;

    private final String resume;
}
