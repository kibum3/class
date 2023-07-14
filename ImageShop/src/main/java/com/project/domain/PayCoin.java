package com.project.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PayCoin {
	
	private int historyNo;
	private int userNo;
	private int itemId;
	private String itemName;
	private int amount;
	private Date regDate;
	
}
