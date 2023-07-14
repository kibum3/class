package com.project.mapper;

import java.util.List;

import com.project.domain.Notice;

public interface NoticeMapper {
	// 공지사항 등록 처리
	public void create(Notice notice) throws Exception;
	// 공지사항 목록 페이지
	public List<Notice> list() throws Exception;
	// 공지사항 상세 페이지
	public Notice read(Integer noticeNo) throws Exception;
	// 공지사항 수정 처리
	public void update(Notice notice) throws Exception;
	// 공지사항 삭제 처리
	public void delete(Integer noticeNo) throws Exception;
}
