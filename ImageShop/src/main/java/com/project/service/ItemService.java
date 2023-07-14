package com.project.service;

import java.util.List;

import com.project.domain.Item;

public interface ItemService {
	// 상품 등록 처리
	public void register(Item item) throws Exception;
	// 상품 상세 페이지
	public Item read(Integer itemId) throws Exception;
	// 상품 수정 처리
	public void modify(Item item) throws Exception;
	// 상품 삭제 처리
	public void remove(Integer itemId) throws Exception;
	// 상품 목록 페이지
	public List<Item> list() throws Exception;
	// 미리보기 이미지 표시
	public String getPreview(Integer itemId) throws Exception;
	// 원본 이미지 표시
	public String getPicture(Integer itemId) throws Exception;
}
