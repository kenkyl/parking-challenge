package com.kyle.parking_challenge.service;

import com.kyle.parking_challenge.model.RateList;

public interface RateService {
	public RateList getCurrentRates(); 
	public void setCurrentRates(RateList rateList); 
	public void clearRates(); 
}
