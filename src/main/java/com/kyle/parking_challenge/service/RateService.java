package com.kyle.parking_challenge.service;


import com.kyle.parking_challenge.model.*;

public interface RateService {
	public RateList getRateList(); 
	public void setRateList(RateList rateList); 
	public void clearRateList(); 
}
