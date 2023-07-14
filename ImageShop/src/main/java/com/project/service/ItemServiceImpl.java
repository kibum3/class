package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.Item;
import com.project.mapper.ItemMapper;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapper mapper;
	
	// 상품 등록 처리
	@Override
	public void register(Item item) throws Exception {
		mapper.create(item);
	}
	
	// 상품 상세 페이지
	@Override
	public Item read(Integer itemId) throws Exception {
		return mapper.read(itemId);
	}

	// 상품 수정 처리
	@Override
	public void modify(Item item) throws Exception {
		mapper.update(item);
	}

	// 상품 삭제 처리
	@Override
	public void remove(Integer itemId) throws Exception {
		mapper.delete(itemId);
	}

	// 상품 목록 페이지
	@Override
	public List<Item> list() throws Exception {
		return mapper.list();
	}

	// 미리보기 이미지 표시
	@Override
	public String getPreview(Integer itemId) throws Exception {
		return mapper.getPreview(itemId);
	}
	
	//원본 이미지 표시
	@Override
	public String getPicture(Integer itemId) throws Exception {
		return mapper.getPicture(itemId);
	}	

}
