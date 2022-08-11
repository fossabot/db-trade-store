package com.db.trade.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.db.trade.entity.TradeStoreEmbeddable;
import com.db.trade.entity.TradeStoreEntity;


@Repository
public interface TradeStoreRepository extends JpaRepository<TradeStoreEntity, TradeStoreEmbeddable> {
	
	@Query(value = "select * from trade_store where trade_id = ?1", nativeQuery = true)
	List<TradeStoreEntity> findAllByTradeId(String tradeId);

	@Query(value = "select * from trade_store where maturity_date < ?1", nativeQuery = true)
	List<TradeStoreEntity> findAllExpiredTrade(Date today);

}
