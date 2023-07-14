package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.Pds;
import com.project.mapper.PdsMapper;

@Service
public class PdsServiceImpl implements PdsService {

	@Autowired
	private PdsMapper mapper;
	
	@Override
	public List<Pds> list() throws Exception {
		return mapper.list();
	}

	@Transactional
	@Override
	public void register(Pds item) throws Exception {
		mapper.create(item);
		
		// 첨부 파일 추가
		String[] files = item.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			mapper.addAttach(fileName);
		}
	}

	@Override
	public List<String> getAttach(Integer itemId) throws Exception {
		return mapper.getAttach(itemId);
	}
	

	@Override
	public Pds read(Integer itemId) throws Exception {
		// 공개 자료 조회 건수 업데이트
		mapper.updateViewCnt(itemId);
		
		return mapper.read(itemId);
	}
	
	@Override
	public void updateAttachDownCnt(String fullName) throws Exception {
		mapper.updateAttachDownCnt(fullName);
	}

	@Transactional
	@Override
	public void modify(Pds item) throws Exception {
		mapper.update(item);

		Integer itemId = item.getItemId();

		mapper.deleteAttach(itemId);

		String[] files = item.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			mapper.replaceAttach(fileName, itemId);
		}
	}
	
	@Transactional
	@Override
	public void remove(Integer itemId) throws Exception {
		mapper.deleteAttach(itemId);
		mapper.delete(itemId);
	}

}
