package com.dmc.cvc.domain.event;


import com.dmc.cvc.domain.event.dto.EventCategorySearchCondition;
import com.dmc.cvc.domain.event.dto.EventListResponseDto;
import com.dmc.cvc.domain.event.dto.EventNameSearchCondition;

import java.util.List;

public interface EventRepositoryCustom {
    List<EventListResponseDto> searchByName(EventNameSearchCondition condition);

    List<EventListResponseDto> searchByCategory(EventCategorySearchCondition condition);

    List<EventListResponseDto> findAllDto();

}
