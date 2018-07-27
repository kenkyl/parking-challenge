package com.kyle.parking_challenge.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kyle.parking_challenge.service.*;

@Configuration
public class ServiceConfig {
	
	@Bean
	public RateService getRateService() {
		return new RateManager();
	}
	
	@Bean
	public PriceService getPriceService() {
		return new PriceCalculator(); 
	}
}
