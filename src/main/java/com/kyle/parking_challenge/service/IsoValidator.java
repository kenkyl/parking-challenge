package com.kyle.parking_challenge.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class IsoValidator implements ValidatorService {

	final static Logger logger = Logger.getLogger(IsoValidator.class);
	private static final String ISO_PATTERN = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])T"+
			"([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]Z";   
	
	public IsoValidator() {
		
	}
	
	public boolean validate(String input) {
		logger.debug("input: " + input);
		if (input.isEmpty() || (!input.matches(ISO_PATTERN))) {
			return false;
		}
		else {
			return true;
		}
	}
	
}
