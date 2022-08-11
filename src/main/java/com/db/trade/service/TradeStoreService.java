package com.db.trade.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.trade.entity.TradeStoreEmbeddable;
import com.db.trade.entity.TradeStoreEntity;
import com.db.trade.exception.TradeStoreValidException;
import com.db.trade.model.TradeStore;
import com.db.trade.repository.TradeStoreRepository;

@Service
public class TradeStoreService {
	
	@Autowired
	private TradeStoreRepository tradeStoreRepository;
	
	@Autowired
    private Validator validator;
	
	public TradeStoreEntity getTradeById(String tradeId, int version) throws TradeStoreValidException{
		Optional<TradeStoreEntity> optionalEntity = tradeStoreRepository.findById
				(new TradeStoreEmbeddable(tradeId, version));
		if(!optionalEntity.isPresent()) {
			throw new TradeStoreValidException("Data not found");
		}
		return optionalEntity.get();
	}
	
	
	public TradeStoreEntity saveTradeStore(TradeStore tradeStore) throws TradeStoreValidException {
		Set<ConstraintViolation<TradeStore>> violations = validator.validate(tradeStore);
		if(!violations.isEmpty()) {
			for (ConstraintViolation<TradeStore> constraintViolation : violations) {
                	throw new TradeStoreValidException(constraintViolation.getMessage());
            }
		}
		
		TradeStoreEntity entity = new TradeStoreEntity();
		entity.setBookId(tradeStore.getBookId());
		entity.setCounterPartyId(tradeStore.getCounterPartyId());
		entity.setMaturityDate(new Date(tradeStore.getMaturityDate()));
		entity.setCreatedDate(new Date());
		entity.setVersion(tradeStore.getVersion());
		entity.setTradeId(tradeStore.getTradeId());
		entity.setExpired(isExpired(tradeStore.getMaturityDate()));
		entity.setTradeStoreEmbeddable(new TradeStoreEmbeddable(tradeStore.getTradeId(), tradeStore.getVersion()));
		tradeStoreRepository.save(entity);
		return entity;
	}
	
	public List<TradeStoreEntity> findAll(){
		return tradeStoreRepository.findAll();
	}
	
	private boolean isExpired(long maturityDate) {
		long currentTime = System.currentTimeMillis();
		return currentTime > maturityDate;
	}


	public TradeStoreEntity updateTradeStore(TradeStore tradeStore) throws TradeStoreValidException {
		getTradeById(tradeStore.getTradeId(), tradeStore.getVersion());
		return saveTradeStore(tradeStore);
		
	}

}
