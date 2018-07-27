package com.kyle.parking_challenge.service;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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
	
	public String getPrice(String timeRange) {
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
	
	private String priceLookup(Calendar start, Calendar end) {
		Integer startHour, endHour, startMin, endMin; 
		String startDay, endDay;
		Rate rate; 
		// grab start time info 
		startDay = start.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("en")).toLowerCase(); 
		startHour = start.get(Calendar.HOUR_OF_DAY);
		startMin = start.get(Calendar.MINUTE); 
		// check for start day match in rates list 
		rate = findRate(startDay, concatTime(startHour, startMin)); 
		if (rate == null) {
			// unavailable --> return -1 
			return "unavailable"; 
		}
		//logger.debug("**START INFO**: " + startDay + " " + startHourStr + " " + startDay + " " + startHour);
		endDay = end.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("en")).toLowerCase();  
		endHour = end.get(Calendar.HOUR_OF_DAY);
		endMin = end.get(Calendar.MINUTE); 
		rate = findRate(endDay, concatTime(endHour, endMin)); 
		if (rate == null) {
			// unavailable --> return -1 
			return "unavailable"; 
		}
		else {
			// return price of matched rate
			logger.info("Returning: " + rate.getPrice());
			return String.valueOf(rate.getPrice()); 
		}
	}
	
	private Rate findRate(String day, int requestTime) {
		logger.info("request: " + day + " " + requestTime);
		for (Rate item : rateService.getRateList().getRates()) {
			// find day match
			if (item != null && !item.getDays().isEmpty() && item.getDays().contains(day)) {
				logger.debug("MATCH: " + item.getDays() + " " + day);
				// find time match 
				String[] limits = item.getTimes().split("-"); 
				logger.info("limits: " + Integer.parseInt(limits[0]) + " " + Integer.parseInt(limits[1]));
				if (requestTime >= Integer.parseInt(limits[0]) && requestTime <= Integer.parseInt(limits[1])) {
					return item; 
				}
			}
		}
		return null; 
	}
	
	private int concatTime(Integer hour, Integer minute) {
		String extraZero = (minute < 10) ? "0" : ""; 
		return Integer.parseInt(String.valueOf(hour) + extraZero + String.valueOf(minute));
	}
}
