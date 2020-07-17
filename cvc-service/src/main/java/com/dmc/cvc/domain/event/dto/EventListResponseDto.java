package com.dmc.cvc.domain.event.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.Date;

@Data
public class EventListResponseDto {
    private Long eventNum;
    private String name;
    private int price;
    private String evt;
    private String product1;
    private String store;
    private String product2;
    private String img;
    private Date registerDate;
    private Date expireDate;


    @QueryProjection
    public EventListResponseDto(Long eventNum, String name, int price,
                                String evt, String product1, String store,
                                String product2, String img, Date registerDate,
                                Date expireDate){
        this.eventNum =  eventNum;
        this.name = name;
        this.price = price;
        this.evt = evt;
        this.product1 = product1;
        this.store = store;
        this.product2 = product2;
        this.img = img;
        this.registerDate = registerDate;
        this.expireDate = expireDate;
    }
}
