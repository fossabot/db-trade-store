package com.db.trade;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TradeAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeAssignmentApplication.class, args);
	}
	
	@Bean
	public BeanWrapper getBeanWrapper() {
		return new BeanWrapperImpl();
	}

}
