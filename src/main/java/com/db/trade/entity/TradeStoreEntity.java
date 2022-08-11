package com.db.trade.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trade_store")
public class TradeStoreEntity {
	
	@EmbeddedId
	TradeStoreEmbeddable tradeStoreEmbeddable;
	
	@Column(name = "trade_id", insertable = false, updatable = false)
	private String tradeId;
	
	@Column(name = "version", insertable = false, updatable = false)
	private int version;
	
	@Column(name = "counter_party_id")
	private String counterPartyId;
	
	@Column(name = "book_id")
	private String bookId;
	
	@Column(name = "maturity_date")
	private Date maturityDate;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "expired")
	private boolean expired;
	
	
	
	public TradeStoreEmbeddable getTradeStoreEmbeddable() {
		return tradeStoreEmbeddable;
	}

	public void setTradeStoreEmbeddable(TradeStoreEmbeddable tradeStoreEmbeddable) {
		this.tradeStoreEmbeddable = tradeStoreEmbeddable;
	}

	public TradeStoreEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCounterPartyId() {
		return counterPartyId;
	}

	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

}
