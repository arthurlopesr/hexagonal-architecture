package com.codeinbook.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookModel {

    @Id
    private String bookId;

    private String title;

    private String subtitle;

    private String description;

    private BigDecimal price;
}
