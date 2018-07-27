package com.kyle.parking_challenge.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kyle.parking_challenge.ValidateException;
import com.kyle.parking_challenge.model.RateList;
import com.kyle.parking_challenge.model.TimeRange;
import com.kyle.parking_challenge.service.PriceService;
import com.kyle.parking_challenge.service.RateService;

@RestController
@RequestMapping(value="/price")
public class PriceController {

	final static Logger logger = Logger.getLogger(PriceController.class);
	
	@Autowired 
	RateService rateService;
	@Autowired
	PriceService priceService;

	@RequestMapping(method=RequestMethod.GET,
			params= {"startTime", "endTime"})
	public String getPrice(
			@RequestParam(value="startTime") String startTime,
			@RequestParam(value="endTime") String endTime) {
		String resp; 
		// retrieve rates 
		logger.debug("Get Price: " + rateService.getRateList());
		try {
			resp = priceService.getPrice(startTime + " to " + endTime);
		} catch (ValidateException e) {
			resp = e.getMessage(); 
		} catch (Exception e) {
			e.printStackTrace();
			resp = "Error!"; 
		}
		return resp; 
	}
}
