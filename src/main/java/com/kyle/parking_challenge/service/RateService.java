package com.kyle.parking_challenge.service;

import java.util.Map;

import com.kyle.parking_challenge.model.*;

public interface RateService {
	public RateList getRateList(); 
	public void setRateList(RateList rateList); 
	//public Map<String,Rate> getRateMap(); 
	public void clearRateList(); 
}
