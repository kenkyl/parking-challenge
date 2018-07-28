package com.kyle.parking_challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kyle.parking_challenge.ValidateException;
import com.kyle.parking_challenge.model.*;

@Service
public class RateManager implements RateService {
	
	@Autowired
	@Qualifier("daysValidator")
	ValidatorService daysValidator; 
	@Autowired
	@Qualifier("timeValidator")
	ValidatorService timeValidator; 
	// maintain a list of Rate objects
	private RateList rateList;
	
	public RateManager() {
		rateList = new RateList(); 
	}
	
	public RateList getRateList() {
		return this.rateList;
	}
	
	public void setRateList(RateList rateList) {
		if (rateList == null || rateList.getRates() == null || rateList.getRates().isEmpty()) {
			throw new ValidateException("Cannot provide empty rate list"); 
		}
		for (Rate rate : rateList.getRates()) {
			if (!daysValidator.validate(rate.getDays())) {
				throw new ValidateException("Invalid days entry");  
			}
			else if (!timeValidator.validate(rate.getTimes())) {
				throw new ValidateException("Invalid times entry"); 
			}
			else if (rate.getPrice() <= 0) {
				throw new ValidateException("Invalid price entry");
			}
		}
		this.rateList = rateList;
	}
	
	public void clearRateList() {
		this.rateList.clear();
	}

}
