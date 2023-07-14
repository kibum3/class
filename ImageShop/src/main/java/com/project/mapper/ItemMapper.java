package com.project.mapper;

import java.util.List;

import com.project.domain.Item;

public interface ItemMapper {
	// 상품 등록 처리
	public void create(Item item) throws Exception;
	// 상품 상세 페이지
	public Item read(Integer itemId) throws Exception;
	// 상품 수정 처리
	public void update(Item item) throws Exception;
	// 상품 삭제 처리
	public void delete(Integer itemId) throws Exception;
	// 상품 목록 페이지
	public List<Item> list() throws Exception;
	// 원본 이미지 표시
	public String getPicture(Integer itemId) throws Exception;
	// 미리보기 이미지 표시
	public String getPreview(Integer itemId) throws Exception;
}
