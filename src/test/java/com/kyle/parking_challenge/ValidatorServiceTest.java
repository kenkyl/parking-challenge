package com.kyle.parking_challenge;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.kyle.parking_challenge.service.*;

public class ValidatorServiceTest {

	// date validator 
	ValidatorService<String> dateValidator; 
	String datesValid1; 
	String datesInvalid1;
	String emptyString; 
	List<String> datesAll; 
	
	// time validator 
	ValidatorService<String> timeValidator; 
	String timeValid1; 
	String timeValid2; 
	String timeInvalid1; 
	String timeInvalid2; 
	String timeInvalid3; 
	String timeEmpty; 
	
	@Before
	public void setup() {
		// date validator setup 
		dateValidator = new DateValidator(); 
		datesValid1 = "mon,thurs,fri";
		datesInvalid1 = "monday, tuesday"; 
		emptyString = "";
		datesAll = Arrays.asList("mon", "tues", "wed", "thurs", "fri", "sat", "sun"); 
		// time validator setup 
		timeValidator = new TimeValidator(); 
		timeValid1 = "0900-2100";
		timeValid2 = "0600-1800"; 
		timeInvalid1 = "12:00 - 1:00"; 
		timeInvalid2 = "8am-12pm";
		timeInvalid3 = "2100-0900"; 
	}
	
	/* DateValidator Tests */
	@Test
	public void validDates1() {
		assertTrue(dateValidator.validate(datesValid1)); 
	}
	
	@Test
	public void invalidDates1() {
		assertFalse(dateValidator.validate(datesInvalid1)); 
	}
	
	@Test 
	public void emptyDates() {
		assertFalse(dateValidator.validate(emptyString)); 
	}
	
	@Test
	public void allDates() {
		for (String day : datesAll) {
			assertTrue(dateValidator.validate(day)); 
		}
	}
	
	/* DateValidator Tests */
	@Test
	public void validTimes1() {
		assertTrue(timeValidator.validate(timeValid1)); 
		assertTrue(timeValidator.validate(timeValid2)); 
	}
	
	@Test
	public void emptyTime() {
		assertFalse(timeValidator.validate(emptyString)); 
	}
	
	@Test
	public void invalidTimes1() {
		assertFalse(timeValidator.validate(timeInvalid1));
		assertFalse(timeValidator.validate(timeInvalid2));
		assertFalse(timeValidator.validate(timeInvalid3));
	}
	

}
