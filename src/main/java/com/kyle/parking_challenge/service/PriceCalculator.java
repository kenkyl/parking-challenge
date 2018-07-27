package com.kyle.parking_challenge.service;

import java.util.Calendar;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kyle.parking_challenge.ValidateException;
import com.kyle.parking_challenge.model.*;

@Service
public class PriceCalculator implements PriceService {

	final static Logger logger = Logger.getLogger(PriceCalculator.class);
	
	@Autowired
	RateService rateService;
	@Autowired
	@Qualifier("isoValidator")
	ValidatorService validatorService; 
	
	public int getPrice(String timeRange) {
		logger.debug("Get price for: " + timeRange);
		if (timeRange.isEmpty()) {
			throw new ValidateException("Empty time range.");
		}
		// validate format of date times and convert to calendar objects 
		String[] times = timeRange.split("\\s*to\\s*");
		Calendar[] timesCal = new Calendar[times.length]; 
		for (int i=0; i<times.length; i++) {
			if (!validatorService.validate(times[i])) {
				throw new ValidateException("Invalid Datetime format. Expected ISO format: YYYY-MM-DDTHH:mm:ssZ");
			}
			timesCal[i] = DatatypeConverter.parseDateTime(times[i]);
			logger.debug("time[" + i + "]: " + timesCal[i]);
		}
		// verify that end date is after start date 
		if (timesCal[0].compareTo(timesCal[1]) >=0) {
			throw new ValidateException("Invalid time range. End date must be later than start date.");
		}
		return priceLookup(timesCal[0], timesCal[1]);
	}
	
	private int priceLookup(Calendar start, Calendar end) {
		
		return 0; 
	}

}
