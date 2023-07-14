package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.ChargeCoin;
import com.project.domain.PayCoin;
import com.project.mapper.CoinMapper;

@Service
public class CoinServiceImpl implements CoinService {
	
	@Autowired
	private CoinMapper mapper;
	
	// 코인 충전 처리
	@Transactional
	@Override
	public void charge(ChargeCoin chargeCoin) throws Exception {
		mapper.charge(chargeCoin);
		mapper.create(chargeCoin); // 코인 충전 내역 등록
	}

	// 충전 내역 페이지
	@Override
	public List<ChargeCoin> list(int userNo) throws Exception {
		return mapper.list(userNo);
	}
	
	// 회원의 상품 구매 내역을 반환한다.
	@Override
	public List<PayCoin> listPayHistory(int userNo) throws Exception {
		return mapper.listPayHistory(userNo);
	}
}
