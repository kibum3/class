package com.project.service;

import java.util.List;

import com.project.domain.Item;
import com.project.domain.Member;
import com.project.domain.UserItem;

public interface UserItemService {
	// 구매 상품 등록 처리
	public void register(Member member, Item item) throws Exception;
	// 구매 상품 보기
	public UserItem read(Integer userItemNo) throws Exception;
	// 구매 상품 목록
	public List<UserItem> list(Integer userNo) throws Exception;
}
