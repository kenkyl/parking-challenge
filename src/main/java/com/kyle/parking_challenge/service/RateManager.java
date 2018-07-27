package com.kyle.parking_challenge.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kyle.parking_challenge.model.*;

@Service
public class RateManager implements RateService {
	// maintain a list of Rate objects
	private RateList rateList;
	private Map<String,Rate> rateMap; 
	
	public RateManager() {
		rateList = new RateList(); 
		rateMap = new HashMap<String,Rate>();
	}
	
	public RateList getRateList() {
		return this.rateList;
	}
	
	public void setRateList(RateList rateList) {
		this.rateMap.clear(); 
		this.rateList = rateList;
		//this.updateMap(); 
	}
	
	public void clearRateList() {
		this.rateList.clear();
		this.rateMap.clear(); 
	}
/*
	public Map<String, Rate> getRateMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void updateMap() {
		for (Rate item : rateList.getRates()) {
			
		}
	}
	*/
}
