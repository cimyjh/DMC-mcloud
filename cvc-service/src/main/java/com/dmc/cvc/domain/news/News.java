package com.dmc.cvc.domain.news;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "news")
public class News {
	
	@Id
    @GeneratedValue
	@Column(name = "news_id")
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




	
}
