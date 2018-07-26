package com.kyle.parking_challenge.service;

import java.util.List;

import com.kyle.parking_challenge.model.Rate;

public interface RateService {
	public List<Rate> getCurrentRates(); 
	public void setCurrentRates(List<Rate> newRates); 
	public void setCurrentRates(Rate newRate); 
	public void clearRates(); 
}
