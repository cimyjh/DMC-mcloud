package com.dmc.cvc.service;

import com.dmc.cvc.domain.news.News;
import com.dmc.cvc.domain.news.NewsRepository;
import com.dmc.cvc.domain.news.NewsRepositoryImpl;
import com.dmc.cvc.domain.news.dto.NewsCategorySearchCondition;
import com.dmc.cvc.domain.news.dto.NewsListResponseDto;
import com.dmc.cvc.domain.news.dto.NewsNameSearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class NewsService {
	
	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	private NewsRepositoryImpl newsRepositoryImpl;


	public List<News> findNews() {
		return newsRepository.findAll();
	}


	public List<News> findByStore(String store) {
		return newsRepository.findByStore(store);
	}


	public News findByNewsNum(Long newsNum) {
		return newsRepository.findByNewsNum(newsNum);
	}


//	public List<News> findByNews_id(int num) {
//		return newsRepository.findByNews_id(num);
//	}



	public Page<News> getNewsList(Pageable pageable){
		int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
		pageable = PageRequest.of(page,9);
		return newsRepository.findAll(pageable);
	}



	public List<NewsListResponseDto> searchByName(String name){
		//뭐 들어가야 하지??
		NewsNameSearchCondition condition = new NewsNameSearchCondition();
		condition.setName(name);

		return newsRepositoryImpl.searchByName(condition);
	}

	public List<NewsListResponseDto> searchByCategory(String product1){
		NewsCategorySearchCondition condition = new NewsCategorySearchCondition();
		condition.setProduct1(product1);

		return newsRepositoryImpl.searchByCategory(condition);
	}







}
