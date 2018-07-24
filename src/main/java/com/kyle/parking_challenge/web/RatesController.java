package com.kyle.parking_challenge.web;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kyle.parking_challenge.model.Rate;
import com.kyle.parking_challenge.service.RateService;

@RestController
public class RatesController {
	
	final static Logger logger = Logger.getLogger(RatesController.class);
	
	@Autowired
	RateService rateService; 

	@RequestMapping(value="/rates", method=RequestMethod.GET)
	public Rate getRates() {
		// retrieve rates 
		logger.debug("Current Rate: " + rateService.getCurrentRate());
		return rateService.getCurrentRate();
	}
	
	@RequestMapping(value="/rates", method=RequestMethod.POST)
	public void setRates() {
		// set rates
		logger.debug("POST: " + rateService.getCurrentRate());
		return;
	}
}
