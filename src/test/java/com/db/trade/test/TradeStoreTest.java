package com.db.trade.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.db.trade.entity.TradeStoreEntity;
import com.db.trade.exception.TradeStoreValidException;
import com.db.trade.model.TradeStore;
import com.db.trade.service.TradeStoreService;
import com.db.trade.utility.DateUtility;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TradeStoreTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private TradeStoreService service;
	
	@Test
	public void getAllTrads() throws Exception {
		mockMvc.perform(get("/tradeStore/getById/T1/1"))
		  .andExpect(status().is2xxSuccessful());
		 
	}
	
	
	@Test
	public void createTradeOrderWithoutFail() throws Exception {
		TradeStore trade = new TradeStore();
		trade.setTradeId("T4");
		trade.setVersion(1);
		trade.setCounterPartyId("CP-4");
		trade.setMaturityDate(DateUtility.getFutureDate(10));
		trade.setBookId("B1");
		TradeStoreEntity entity = service.saveTradeStore(trade);
		assertEquals("B1", entity.getBookId());
		/*mockMvc.perform(post("/tradeStore/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(trade)))
		  .andExpect(status().isCreated());*/
		 
	}
	
	@Test
	public void updateTradeOrder() throws Exception {
		TradeStore trade = new TradeStore();
		trade.setTradeId("T3");
		trade.setVersion(4);
		trade.setCounterPartyId("CP-4");
		trade.setMaturityDate(DateUtility.getPastDate(10));
		trade.setBookId("B1");
		TradeStoreEntity entity = service.updateTradeStore(trade);
		assertEquals("B1", entity.getBookId());
		/*mockMvc.perform(put("/tradeStore/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(trade)))
		  .andExpect(status().isCreated());*/
		 
	}
	
	
	@Test(expected = TradeStoreValidException.class)
	public void createTradeOrderVersionOutDated() throws Exception {
		TradeStore trade = new TradeStore();
		trade.setTradeId("T1");
		trade.setVersion(0);
		trade.setCounterPartyId("CP-4");
		trade.setMaturityDate(DateUtility.getFutureDate(10));
		trade.setBookId("B1");
		service.saveTradeStore(trade);
		/*mockMvc.perform(post("/tradeStore/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(trade)))
		 		.andExpect(status().is5xxServerError());*/
	}
	
	
	@Test(expected = TradeStoreValidException.class)
	public void createTradeExpiredDated() throws Exception {
		TradeStore trade = new TradeStore();
		trade.setTradeId("T1");
		trade.setVersion(0);
		trade.setCounterPartyId("CP-4");
		trade.setMaturityDate(DateUtility.getFutureDate(10));
		trade.setBookId("B1");
		service.saveTradeStore(trade);
		/*mockMvc.perform(MockMvcRequestBuilders.post("/tradeStore/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(trade)))
		 		.andExpect(status().is5xxServerError());*/
		 
	}
	
	
	@Test(expected = TradeStoreValidException.class)
	public void updateTradeOrderNoFound() throws Exception {
		TradeStore trade = new TradeStore();
		trade.setTradeId("T1");
		trade.setVersion(100);
		trade.setCounterPartyId("CP-4");
		trade.setMaturityDate(DateUtility.getFutureDate(10));
		trade.setBookId("B1");
		service.updateTradeStore(trade);
		/*mockMvc.perform(MockMvcRequestBuilders.post("/tradeStore/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(trade)))
		 		.andExpect(status().is5xxServerError());*/
		 
	}
	
	@Test
	public void findAllTrads() throws Exception {
		List<TradeStoreEntity> allEntity = service.findAll();
		assertEquals(6, allEntity.size());
		 
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}   
}
