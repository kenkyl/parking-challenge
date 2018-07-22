package com.kyle.parking_challenge.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.kyle.parking_challenge.model.*;

@Service
public class RateService {
	private Rate currentRate; 
	
	public RateService() {
		Date start = new Date();
		Date end = new Date(); 
		TimeLimit limit = new TimeLimit(start, end); 
		this.currentRate = new Rate("mon,tues", limit, 1500); 
	}
	
	public Rate getCurrentRate() {
		return this.currentRate;
	}
	
	public void setCurrnetRate(Rate newRate) {
		this.currentRate = newRate; 
	}
}
