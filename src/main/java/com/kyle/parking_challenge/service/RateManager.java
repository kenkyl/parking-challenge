package com.kyle.parking_challenge.service;

import org.springframework.stereotype.Service;

import com.kyle.parking_challenge.model.*;

@Service
public class RateManager implements RateService {
	// maintain a list of Rate objects
	private RateList rateList = new RateList(); 
	
	public RateManager() {
		
	}
	
	public RateList getCurrentRates() {
		return this.rateList;
	}
	
	public void setCurrentRates(RateList rateList) {
		this.rateList = rateList; 
	}
	
	public void clearRates() {
		this.rateList.clear();
	}
	
}
