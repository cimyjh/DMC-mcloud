package com.dmc.cvc.domain.news;


import com.dmc.cvc.domain.news.dto.NewsCategorySearchCondition;
import com.dmc.cvc.domain.news.dto.NewsListResponseDto;
import com.dmc.cvc.domain.news.dto.NewsNameSearchCondition;
import com.dmc.cvc.domain.news.dto.QNewsListResponseDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.dmc.cvc.domain.news.QNews.news;
import static org.springframework.util.StringUtils.isEmpty;


public class NewsRepositoryImpl implements com.dmc.cvc.domain.news.NewsRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public NewsRepositoryImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<NewsListResponseDto> searchByName(NewsNameSearchCondition condition) {
        return queryFactory
                .select(new QNewsListResponseDto(
                        news.newsNum,
                        news.name,
                        news.price,
                        news.product1,
                        news.product2,
                        news.thumbnail,
                        news.img,
                        news.store,
                        news.detail,
                        news.registerDate))
                .from(news)
                .where(newsNameEq(condition.getName()))
                .fetch();
    }

    @Override
    public List<NewsListResponseDto> searchByCategory(NewsCategorySearchCondition condition) {
        return queryFactory
                .select(new QNewsListResponseDto(
                        news.newsNum,
                        news.name,
                        news.price,
                        news.product1,
                        news.product2,
                        news.thumbnail,
                        news.img,
                        news.store,
                        news.detail,
                        news.registerDate))
                .from(news)
                .where(newsProduct1Eq(condition.getProduct1()))
                .fetch();
    }

    @Override
    public List<NewsListResponseDto> findAllDto() {
        return queryFactory
                .select(new QNewsListResponseDto(
                        news.newsNum,
                        news.name,
                        news.price,
                        news.product1,
                        news.product2,
                        news.thumbnail,
                        news.img,
                        news.store,
                        news.detail,
                        news.registerDate))
                .from(news)
                .fetch();
    }


    private BooleanExpression newsNameEq(String name) {
        return isEmpty(name) ? null : news.name.contains(name);
    }

    private BooleanExpression newsProduct1Eq(String product1) {
        return isEmpty(product1) ? null : news.product1.eq(product1);
    }

}
