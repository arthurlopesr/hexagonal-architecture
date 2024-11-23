package com.codeinbook.application.adapter.out.producer;

import com.codeinbook.common.dto.CategoryBookEventDTO;
import com.codeinbook.domain.port.out.producer.EventProducerPort;
import com.codeinbook.infrastructure.event.CategoryDeletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class EventProducerAdapter implements EventProducerPort {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    @Transactional
    public void updateCategoryBook(CategoryBookEventDTO categoryBookEventDTO) {
        applicationEventPublisher.publishEvent(CategoryDeletedEvent.of(categoryBookEventDTO));
    }
}
