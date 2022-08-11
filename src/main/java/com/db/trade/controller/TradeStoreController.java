package com.db.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.trade.entity.TradeStoreEntity;
import com.db.trade.exception.TradeStoreValidException;
import com.db.trade.model.TradeStore;
import com.db.trade.service.TradeStoreService;

@RestController
@RequestMapping("/tradeStore")
public class TradeStoreController {
	
	@Autowired
	TradeStoreService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> createTradeEntry(@RequestBody TradeStore tradeStore) throws Exception{
		try {
			service.saveTradeStore(tradeStore);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (TradeStoreValidException e) {
			throw new TradeStoreValidException(e.getMessage());
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTradeEntry(@RequestBody TradeStore tradeStore) throws Exception{
		try {
			service.saveTradeStore(tradeStore);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (TradeStoreValidException e) {
			throw new TradeStoreValidException(e.getMessage());
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@GetMapping("/getById/{tradeId}/{version}")
	public ResponseEntity<TradeStoreEntity> getTradeById(@PathVariable String tradeId, @PathVariable int version) throws Exception{
		try {
			TradeStoreEntity entity = service.getTradeById(tradeId, version);
			return new ResponseEntity<>(entity,HttpStatus.OK);
		}catch (TradeStoreValidException e) {
			throw new TradeStoreValidException(e.getMessage());
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("Trade store in running.....",HttpStatus.OK);
	}

}
