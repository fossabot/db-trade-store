package com.db.trade.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TradeStoreEmbeddable implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "trade_id", insertable = false, updatable = false)
	String tradeId;
	
	@Column(name = "version", insertable = false, updatable = false)
	int version;
	
	public TradeStoreEmbeddable() {
		super();
	}
	
	public TradeStoreEmbeddable(String tradeId, int version) {
		this.tradeId = tradeId;
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result;
		result = prime * result + ((tradeId == null) ? 0 : tradeId.hashCode());
		result = prime * result + version;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeStoreEmbeddable other = (TradeStoreEmbeddable) obj;
		if (tradeId == null) {
			if (other.tradeId != null)
				return false;
		} else if (!tradeId.equals(other.tradeId))
			return false;
		if (version != other.version)
			return false;
		return true;
	}
}