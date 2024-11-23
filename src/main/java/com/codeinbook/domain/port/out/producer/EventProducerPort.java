package com.codeinbook.domain.port.out.producer;

import com.codeinbook.common.dto.CategoryBookEventDTO;

public interface EventProducerPort {
    void updateCategoryBook(CategoryBookEventDTO categoryBookEventDTO);
}
