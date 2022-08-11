package com.db.trade.utility;

import java.time.LocalDate;
import java.util.Date;

public class DateUtility {

	
	public static long getFutureDate(int futureDay) {
		LocalDate tomorrow = LocalDate.now().plusDays(futureDay);
		return tomorrow.toEpochDay();
	}
	
	
	public static long getPastDate(int pastDay) {
		LocalDate tomorrow = LocalDate.now().minusDays(pastDay);
		return tomorrow.toEpochDay();
	}
	
	public static Date getDate(long dateTime) {
		return new Date(dateTime);
	}
}
