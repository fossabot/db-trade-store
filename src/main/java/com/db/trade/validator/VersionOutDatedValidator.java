package com.db.trade.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.trade.entity.TradeStoreEntity;
import com.db.trade.model.TradeStore;
import com.db.trade.repository.TradeStoreRepository;
import com.db.trade.validation.VersionOutDatedValidation;

@Service
public class VersionOutDatedValidator implements ConstraintValidator<VersionOutDatedValidation, Object> {
	
	@Autowired
	TradeStoreRepository repository;
	
	@Autowired
	private BeanWrapper wrapper ;
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		 TradeStore tradeStore = this.wrapper.convertIfNecessary(value,TradeStore.class);
		 String objTradeId = tradeStore.getTradeId();
		 Integer objVersion = tradeStore.getVersion();
		 List<TradeStoreEntity> all =  repository.findAllByTradeId(objTradeId);
		 int maxVersion = all.stream().mapToInt(entity -> entity.getVersion()).max().orElse(-1);
		 return objVersion >= maxVersion;
	}

}
