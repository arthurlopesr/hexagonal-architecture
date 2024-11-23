package com.codeinbook.infrastructure.event;

import com.codeinbook.common.dto.CategoryBookEventDTO;
import org.springframework.context.ApplicationEvent;

public class CategoryDeletedEvent extends ApplicationEvent {

    public CategoryDeletedEvent(Object source) {
        super(source);
    }

    public static CategoryDeletedEvent of(CategoryBookEventDTO categoryBookEventDTO) {
        return new CategoryDeletedEvent(categoryBookEventDTO);
    }
}
