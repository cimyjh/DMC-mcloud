package com.dmc.cvc.domain.event;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "event")
public class Event {
	
	@Id
    @GeneratedValue
	@Column(name = "event_id")
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

}