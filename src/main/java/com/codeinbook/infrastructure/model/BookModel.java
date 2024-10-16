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
public class BookModel {

    public BookModel(String bookId, String title, String subtitle, String description, BigDecimal price) {
        this.bookId = bookId;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.price = price;
    }

    @Id
    private String bookId;

    private final String title;

    private final String subtitle;

    private final String description;

    private final BigDecimal price;

    public void with(BookDTO bookDTO) {
        this.bookId = Objects.nonNull(bookDTO.bookId()) ? bookDTO.bookId() : this.bookId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
