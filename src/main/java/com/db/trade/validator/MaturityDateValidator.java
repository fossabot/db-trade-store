package com.db.trade.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.db.trade.entity.TradeStoreEmbeddable;
import com.db.trade.entity.TradeStoreEntity;
import com.db.trade.exception.TradeStoreValidException;
import com.db.trade.model.TradeStore;
import com.db.trade.repository.TradeStoreRepository;
import com.db.trade.validation.MaturityDateValidation;

public class MaturityDateValidator implements ConstraintValidator<MaturityDateValidation, Object>{
	
	@Autowired
	BeanWrapper wrapper;
	
	@Autowired
	TradeStoreRepository repository;
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		TradeStore tradeStore = this.wrapper.convertIfNecessary(value,TradeStore.class);
		Optional<TradeStoreEntity> optionalEntity = 
				repository.findById(new TradeStoreEmbeddable(tradeStore.getTradeId(), tradeStore.getVersion()));
		if(optionalEntity.isPresent()) {
			TradeStoreEntity entity = optionalEntity.get();
			long currentTime = System.currentTimeMillis();
			return currentTime < entity.getMaturityDate().getTime();
		}
		return true;
	}

}
