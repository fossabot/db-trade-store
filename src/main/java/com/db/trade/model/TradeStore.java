package com.db.trade.model;

import com.db.trade.validation.MaturityDateValidation;
import com.db.trade.validation.VersionOutDatedValidation;

@VersionOutDatedValidation(tradeId = "tradeId",  version = "version")
@MaturityDateValidation
public class TradeStore {
	private String tradeId;
	private int version;	
	private String counterPartyId;
	private String bookId;
	private long maturityDate;

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

	public long getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(long maturityDate) {
		this.maturityDate = maturityDate;
	}

}
