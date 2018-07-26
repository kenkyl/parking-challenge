package com.kyle.parking_challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kyle.parking_challenge.model.*;

@Service
public class RateManager implements RateService {
	// maintain a list of Rate objects
	private List<Rate> currentRates = new ArrayList<Rate>(); 
	
	public RateManager() {

	}
	
	public List<Rate> getCurrentRates() {
		return this.currentRates;
	}
	
	public void setCurrentRates(List<Rate> newRates) {
		this.currentRates = newRates; 
	}
	
	public void setCurrentRates(Rate newRate) {
		this.clearRates(); 
		this.currentRates.add(newRate);
	}
	
	public void clearRates() {
		this.currentRates.clear();
	}
	
}
