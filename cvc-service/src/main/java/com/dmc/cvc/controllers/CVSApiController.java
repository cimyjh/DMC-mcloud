package com.dmc.cvc.controllers;

import com.dmc.cvc.apiException.NotFoundException;
import com.dmc.cvc.domain.event.EventRepository;
import com.dmc.cvc.domain.event.dto.EventCategorySearchCondition;
import com.dmc.cvc.domain.event.dto.EventListResponseDto;
import com.dmc.cvc.domain.event.dto.EventNameSearchCondition;
import com.dmc.cvc.domain.news.NewsRepository;
import com.dmc.cvc.domain.news.dto.NewsCategorySearchCondition;
import com.dmc.cvc.domain.news.dto.NewsListResponseDto;
import com.dmc.cvc.domain.news.dto.NewsNameSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CVSApiController {

    private final EventRepository eventRepository;
    private final NewsRepository newsRepository;


    @GetMapping("/v1/event")
    public List<EventListResponseDto> findAll(){
        return eventRepository.findAllDto();
    }

    @GetMapping("/v1/event/searchByName")
    public List<EventListResponseDto> searchByName(EventNameSearchCondition condition){
        List<EventListResponseDto> eventList = eventRepository.searchByName(condition);

        if(eventList.isEmpty()){
            throw new NotFoundException(String.format("name[%s] not found",condition));
        }

        return eventList;
    }

    @GetMapping("/v1/event/searchByCategory")
    public List<EventListResponseDto> searchByCategory(EventCategorySearchCondition condition){
        List<EventListResponseDto> eventList = eventRepository.searchByCategory(condition);

        if(eventList.isEmpty()){
            throw new NotFoundException(String.format("name[%s] not found", condition));
        }

        return eventList;
    }

    @GetMapping("/v1/news")
    public List<NewsListResponseDto> NewsFindAll(){
        return newsRepository.findAllDto();
    }


    @GetMapping("/v1/news/searchByName")
    public List<NewsListResponseDto> searchByName(NewsNameSearchCondition condition){
        List<NewsListResponseDto> newsList = newsRepository.searchByName(condition);

        if(newsList.isEmpty()){
            throw new NotFoundException(String.format("name[%s] not found", condition));
        }

        return newsList;
    }


    @GetMapping("/v1/news/searchByCategory")
    public List<NewsListResponseDto> searchByCategory(NewsCategorySearchCondition condition){
        List<NewsListResponseDto> newsList = newsRepository.searchByCategory(condition);

        if(newsList.isEmpty()){
            throw new NotFoundException(String.format("name[%s] not found", condition));
        }

        return newsList;
    }


}
