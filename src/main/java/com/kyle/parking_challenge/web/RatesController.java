package com.kyle.parking_challenge.web;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kyle.parking_challenge.model.Rate;
import com.kyle.parking_challenge.model.RateList;
import com.kyle.parking_challenge.service.*;

@RestController
public class RatesController {
	
	final static Logger logger = Logger.getLogger(RatesController.class);
	
	@Autowired
	RateService rateService; 
	
	@RequestMapping(value="/rates", method=RequestMethod.GET)
	public @ResponseBody RateList getRates() {
		// retrieve rates 
		logger.debug("Current Rate: " + rateService.getCurrentRates());
		return rateService.getCurrentRates();
	}
	
	@RequestMapping(value="/rates", method=RequestMethod.POST)
	public void setRates(@RequestBody RateList newRates) {
		// set rates
		logger.debug("POST: " + newRates.getRates());
		rateService.setCurrentRates(newRates);
		return;
	}
}
