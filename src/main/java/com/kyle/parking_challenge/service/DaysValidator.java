package com.kyle.parking_challenge.service;

import java.util.Arrays;
import java.util.List;

public class DaysValidator implements ValidatorService {

	private static final List<String> DAYS = Arrays.asList("mon", "tues", "wed", "thurs", "fri", "sat", "sun"); 
	
	public DaysValidator() {
		 
	}
	
	public boolean validate(String input) {
		if (input.isEmpty()) {
			return false; 
		}
		String[] inputArray = input.split("\\s*,\\s*");
		for (String item : inputArray) {
			if (! DAYS.contains(item)) {
				return false; 
			}
		}
		return true; 
	}
}
