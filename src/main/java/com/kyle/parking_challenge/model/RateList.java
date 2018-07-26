package com.kyle.parking_challenge.model;

import java.util.ArrayList;
import java.util.List;

public class RateList {
	private List<Rate> rates;
	
	public RateList() {
		this.rates = new ArrayList<Rate>(); 
	}
	
	public RateList(List<Rate> rates) {
		this.rates = rates;
	}
	
	public List<Rate> getRates() {
		return this.rates; 
	}
	
	public void setRates(List<Rate> newRates) {
		this.rates = newRates; 
	}
	
	public int size() {
		return this.rates.size();
	}
	
	public void clear() {
		this.rates.clear(); 
	}
}
