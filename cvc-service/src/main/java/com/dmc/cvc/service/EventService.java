package com.dmc.cvc.service;

import com.dmc.cvc.domain.event.Event;
import com.dmc.cvc.domain.event.EventRepository;
import com.dmc.cvc.domain.event.EventRepositoryImpl;
import com.dmc.cvc.domain.event.dto.EventCategorySearchCondition;
import com.dmc.cvc.domain.event.dto.EventListResponseDto;
import com.dmc.cvc.domain.event.dto.EventNameSearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private EventRepositoryImpl eventRepositoryImpl;


	
	public List<Event> findEvents() {
		return eventRepository.findAll();
	}

	public List<Event> findByStore(String store) {
		return eventRepository.findByStore(store);
	}


	public Page<Event> getEventList(Pageable pageable){
		int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
		pageable = PageRequest.of(page,9);
		return eventRepository.findAll(pageable);
	}

	public List<EventListResponseDto> searchByName(String name){
		//뭐 들어가야 하지??
		EventNameSearchCondition condition = new EventNameSearchCondition();
		condition.setName(name);

		return eventRepositoryImpl.searchByName(condition);
	}

	public List<EventListResponseDto> searchByCategory(String evt, String product1){
		EventCategorySearchCondition condition = new EventCategorySearchCondition();
		condition.setEvt(evt);
		condition.setProduct1(product1);

		return eventRepositoryImpl.searchByCategory(condition);
	}

	@Transactional(readOnly = true)
	public List<Event> findAll(){
		return eventRepository.findAll();
	}


}
