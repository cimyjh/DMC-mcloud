package com.dmc.cvc.domain.news;


import com.dmc.cvc.domain.news.dto.NewsCategorySearchCondition;
import com.dmc.cvc.domain.news.dto.NewsListResponseDto;
import com.dmc.cvc.domain.news.dto.NewsNameSearchCondition;

import java.util.List;

public interface NewsRepositoryCustom {
    List<NewsListResponseDto> searchByName(NewsNameSearchCondition condition);

    List<NewsListResponseDto> searchByCategory(NewsCategorySearchCondition condition);

    List<NewsListResponseDto> findAllDto();

}
