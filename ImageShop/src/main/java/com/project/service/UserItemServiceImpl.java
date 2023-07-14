package com.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.domain.Item;
import com.project.domain.Member;
import com.project.domain.PayCoin;
import com.project.domain.UserItem;
import com.project.exception.NotEnoughCoinException;
import com.project.mapper.CoinMapper;
import com.project.mapper.UserItemMapper;

@Service
public class UserItemServiceImpl implements UserItemService {

	@Autowired
	private UserItemMapper mapper;
	
	@Autowired
	private CoinMapper coinMapper;
	
	// 구매 상품 등록 처리
	@Transactional
	@Override
	public void register(Member member, Item item) throws Exception {
		int userNo = member.getUserNo();
		// 회원이 가진 코인을 가져온다.
		int coin = member.getCoin();
	   
		int itemId = item.getItemId();
		int price = item.getPrice();
		
		UserItem userItem = new UserItem();
		userItem.setUserNo(userNo);
		userItem.setItemId(itemId);
		
		// 사용자의 코인이 부족한지 체크한다.
		if(coin < price) {
			throw new NotEnoughCoinException("코인이 부족합니다.");
		}
		
		PayCoin payCoin = new PayCoin();
		payCoin.setUserNo(userNo);
		payCoin.setItemId(itemId);
		payCoin.setAmount(price);
		
		coinMapper.pay(payCoin);  // 코인 지급
		coinMapper.createPayHistory(payCoin);  // 구매 내역 등록
		
		mapper.create(userItem);
	}

	// 구매 상품 보기
	@Override
	public UserItem read(Integer userItemNo) throws Exception {
		return mapper.read(userItemNo);
	}

	// 회원 구매 상품 목록
	@Override
	public List<UserItem> list(Integer userNo) throws Exception {
		return mapper.list(userNo);
	}
}
