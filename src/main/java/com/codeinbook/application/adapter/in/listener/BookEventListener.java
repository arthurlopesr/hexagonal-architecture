package com.codeinbook.application.adapter.in.listener;

import com.codeinbook.common.dto.CategoryBookEventDTO;
import com.codeinbook.domain.port.in.BookServicePort;
import com.codeinbook.infrastructure.event.CategoryDeletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class BookEventListener {

    private final BookServicePort bookServicePort;

    @Async
    @TransactionalEventListener
    public void onCategoryEventDeleted(CategoryDeletedEvent categoryDeletedEvent) {
        CategoryBookEventDTO eventDTO = (CategoryBookEventDTO) categoryDeletedEvent.getSource();
        bookServicePort.updateAllCategoriesId(eventDTO);
    }
}
