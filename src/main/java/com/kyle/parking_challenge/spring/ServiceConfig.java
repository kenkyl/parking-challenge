package com.kyle.parking_challenge.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kyle.parking_challenge.service.RateService;

@Configuration
public class ServiceConfig {
	
	@Bean
	public RateService getRateService() {
		return new RateService();
	}
}