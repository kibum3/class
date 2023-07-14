package com.project.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChargeCoin {
	
	private int historyNo;
	private int userNo;
	private int amount;
	private Date regDate;

}
