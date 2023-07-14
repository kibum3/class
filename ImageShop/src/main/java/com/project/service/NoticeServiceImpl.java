package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.Notice;
import com.project.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper mapper;
	
	// 공지사항 등록 처리
	@Override
	public void register(Notice notice) throws Exception {
		mapper.create(notice);
	}
	
	// 공지사항 목록 페이지
	@Override
	public List<Notice> list() throws Exception {
		return mapper.list();
	}
	
	// 공지사항 상세 페이지
	@Override
	public Notice read(Integer noticeNo) throws Exception {
		return mapper.read(noticeNo);
	}
	
	// 공지사항 수정 처리
	@Override
	public void modify(Notice notice) throws Exception {
		mapper.update(notice);
	}
	
	// 공지사항 삭제 처리
	@Override
	public void remove(Integer noticeNo) throws Exception {
		mapper.delete(noticeNo);
	}

}
