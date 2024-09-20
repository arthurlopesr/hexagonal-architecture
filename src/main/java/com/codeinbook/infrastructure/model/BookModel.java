package com.codeinbook.infrastructure.model;

import com.codeinbook.common.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Objects;

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

    public void with(BookDTO bookDTO) {
        this.bookId = Objects.nonNull(bookDTO.bookId()) ? bookDTO.bookId() : this.bookId;
    }
}
