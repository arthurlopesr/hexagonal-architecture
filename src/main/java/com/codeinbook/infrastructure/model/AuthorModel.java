package com.codeinbook.infrastructure.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AuthorModel {

    public AuthorModel(String authorId, String resume, String name) {
        this.authorId = authorId;
        this.resume = resume;
        this.name = name;
    }

    @Id
    private String authorId;

    private String name;

    public String getName() {
        return name;
    }

    private String resume;

    public String getResume() {
        return resume;
    }
}
