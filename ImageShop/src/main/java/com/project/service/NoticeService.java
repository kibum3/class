package com.project.service;

import java.util.List;

import com.project.domain.Notice;

public interface NoticeService {
	// 공지사항 등록 처리
	public void register(Notice notice) throws Exception;
	// 공지사항 목록 페이지
	public List<Notice> list() throws Exception;
	// 공지사항 상세 페이지
	public Notice read(Integer noticeNo) throws Exception;
	// 공지사항 수정 처리
	public void modify(Notice notice) throws Exception;
	// 공지사항 삭제 처리
	public void remove(Integer noticeNo) throws Exception;	
}
