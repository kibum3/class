package com.project.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pds {
	
	private Integer itemId;
	private String itemName;
	private String description;
	private String[] files;
	private Integer viewCnt;
	
}
