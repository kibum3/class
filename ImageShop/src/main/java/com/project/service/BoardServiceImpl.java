package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.domain.PageRequest;
import com.project.domain.Board;
import com.project.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	// 게시글 등록 처리
	@Override
	public void register(Board board) throws Exception {
		mapper.create(board);
	}
	// 게시글 목록 페이지 삭제
	/*
	@Override
	public List<Board> list() throws Exception {
		return mapper.list();
	}
	*/
	
	// 페이징 요청 정보를 매개 변수로 받아 페이징 처리를 한 게시글 목록을 반환한다.
	@Override
	public List<Board> list(PageRequest pageRequest) throws Exception {
		return mapper.list(pageRequest);
	}
	// 게시글 상세 페이지
	@Override
	public Board read(Integer boardNo) throws Exception {
		return mapper.read(boardNo);
	}
	// 게시글 수정 처리
	@Override
	public void modify(Board board) throws Exception {
		mapper.update(board);
	}
	// 게시글 삭제 처리
	@Override
	public void remove(Integer boardNo) throws Exception {
		mapper.delete(boardNo);
	}
	// 게시글 전체 건수를 반환한다.
	/* 삭제
	@Override
	public int count() throws Exception {
		return mapper.count();
	}
	*/
	// 검색 처리된 게시글 건수를 반환한다.
	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return mapper.count(pageRequest);
	}
}
