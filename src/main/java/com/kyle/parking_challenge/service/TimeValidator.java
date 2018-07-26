package com.kyle.parking_challenge.service;

import org.apache.log4j.Logger;

public class TimeValidator implements ValidatorService<String> {
	final static Logger logger = Logger.getLogger(TimeValidator.class);

	// define regex pattern for valid date entry
	private static final String TIME24_PATTERN = "([01][0-9]|2[0-3])[0-5][0-9]";
	private static final String INPUT_PATTERN = TIME24_PATTERN + "-" + TIME24_PATTERN; 
	
	public boolean validate(String input) {
		logger.debug("input: " + input);
		if (input.isEmpty() || (!input.matches(INPUT_PATTERN)) || (!validateTimeRange(input))) return false;
		else return true; 
	}
	
	// validate that the end time is later than start time 
	private boolean validateTimeRange(String range) {
		int start, end; 
		String[] times = range.split("-"); 
		start = Integer.parseInt(times[0]); 
		end = Integer.parseInt(times[1]); 
		logger.debug("start - end: " + start + " " + end);
		if (start >= end) return false; 
		return true; 
	}
}
