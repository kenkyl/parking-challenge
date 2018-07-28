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
	
	@Bean(name="isoValidator") 
	public ValidatorService getIsoValidator() {
		return new IsoValidator(); 
	}
	
	@Bean(name="timeValidator") 
	public ValidatorService getTimeValidator() {
		return new TimeValidator(); 
	}
	
	@Bean(name="daysValidator") 
	public ValidatorService getDaysValidator() {
		return new DaysValidator(); 
	}
}
