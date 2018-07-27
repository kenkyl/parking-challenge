package com.kyle.parking_challenge.service;

import org.springframework.stereotype.Service;

import com.kyle.parking_challenge.model.*;

@Service
public class RateManager implements RateService {
	// maintain a list of Rate objects
	private RateList rateList = new RateList(); 
	
	public RateManager() {
		
	}
	
	public RateList getRateList() {
		return this.rateList;
	}
	
	public void setRateList(RateList rateList) {
		this.rateList = rateList; 
	}
	
	public void clearRateList() {
		this.rateList.clear();
	}
	
}
