package com.kyle.parking_challenge.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kyle.parking_challenge.model.Rate;
import com.kyle.parking_challenge.service.RateService;

@RestController
public class RatesController {
	
	@Autowired
	RateService rateService; 

	@RequestMapping(value="/rates", method=RequestMethod.GET,  produces = "application/json")
	public Rate getRates() {
		// retrieve rates 
		return rateService.getCurrentRate();
	}
	
	@RequestMapping(value="/rates", method=RequestMethod.POST)
	public void setRates() {
		// set rates
		return;
	}
}
