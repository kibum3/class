package com.project.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Notice {
	
	private int noticeNo;
	private String title;
	private String content;
	private Date regDate;

}
