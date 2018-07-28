package com.kyle.parking_challenge.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kyle.parking_challenge.ValidateException;
import com.kyle.parking_challenge.model.RateList;
import com.kyle.parking_challenge.service.*;

@RestController
@RequestMapping(value="/rates")
public class RatesController {
	
	final static Logger logger = Logger.getLogger(RatesController.class);
	
	@Autowired
	RateService rateService; 
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public RateList getRates() {
		// retrieve rates 
		logger.debug("Current Rate: " + rateService.getRateList());
		return rateService.getRateList();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String setRates(@RequestBody RateList newRates) {
		String resp = "Success"; 
		// set rates
		logger.debug("POST: " + newRates.getRates());
		try {
			rateService.setRateList(newRates);
		} catch (ValidateException e) {
			resp = e.getMessage();
		} catch (Exception e) {
			e.printStackTrace(); 
			resp = e.getMessage(); 
		}
		return resp; 
	}
}
