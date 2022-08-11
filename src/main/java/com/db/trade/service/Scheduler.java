package com.db.trade.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.db.trade.entity.TradeStoreEntity;
import com.db.trade.repository.TradeStoreRepository;

@Service
public class Scheduler {
	
	@Autowired
	TradeStoreRepository repository;
	
	@Scheduled(cron = "0 0 1 ? * *")
	public void updateTradeExpire() {
		List<TradeStoreEntity> allExpiredTrade = repository.findAllExpiredTrade(new Date());
		for(TradeStoreEntity trade : allExpiredTrade) {
			trade.setExpired(true);
		}
		repository.saveAll(allExpiredTrade);
	}

}
