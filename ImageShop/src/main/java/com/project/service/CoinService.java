package com.project.service;

import java.util.List;

import com.project.domain.ChargeCoin;
import com.project.domain.PayCoin;

public interface CoinService {
	// 코인 충전 처리
	public void charge(ChargeCoin chargeCoin) throws Exception;
	// 충전 내역 페이지
	public List<ChargeCoin> list(int userNo) throws Exception;
	// 회원의 상품 구매 내역을 반환한다.
	public List<PayCoin> listPayHistory(int userNo) throws Exception;
}
