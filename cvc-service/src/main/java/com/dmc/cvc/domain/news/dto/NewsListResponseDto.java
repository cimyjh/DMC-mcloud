package com.dmc.cvc.domain.news.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.Date;

@Data
public class NewsListResponseDto {
    private Long newsNum;
    private String name;
    private int price;
    private String product1;
    private String product2;
    private String thumbnail;
    private String img;
    private String store;
    private String detail;
    private Date registerDate;


    @QueryProjection
    public NewsListResponseDto(Long newsNum, String name, int price,
                               String product1, String product2, String thumbnail,
                               String img, String store, String detail, Date registerDate){
        this.newsNum =  newsNum;
        this.name = name;
        this.price = price;
        this.product1 = product1;
        this.product2 = product2;
        this.thumbnail = thumbnail;
        this.img = img;
        this.store = store;
        this.detail = detail;
        this.registerDate = registerDate;
    }
}
