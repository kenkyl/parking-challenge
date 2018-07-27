package com.kyle.parking_challenge;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.kyle.parking_challenge.service.*;

public class ValidatorServiceTest {

	String emptyString; 
	
	// date validator 
	ValidatorService daysValidator; 
	String daysValid1; 
	String daysInvalid1;
	List<String> daysAll; 
	
	// time validator 
	ValidatorService timeValidator; 
	String timeValid1, timeValid2; 
	String timeInvalid1, timeInvalid2, timeInvalid3; 
	
	// iso validator 
	ValidatorService isoValidator; 
	String isoValid1, isoValid2; 
	String isoInvalid1, isoInvalid2, isoInvalid3, isoInvalid4, isoInvalid5, isoInvalid6; 
	
	@Before
	public void setup() {
		emptyString = "";
		// date validator setup 
		daysValidator = new DaysValidator(); 
		daysValid1 = "mon,thurs,fri";
		daysInvalid1 = "monday, tuesday"; 
		daysAll = Arrays.asList("mon", "tues", "wed", "thurs", "fri", "sat", "sun"); 
		// time validator setup 
		timeValidator = new TimeValidator(); 
		timeValid1 = "0900-2100";
		timeValid2 = "0600-1800"; 
		timeInvalid1 = "12:00 - 1:00"; 
		timeInvalid2 = "0970-2100";
		timeInvalid3 = "2100-0900"; 
		// time range validator setup 
		isoValidator = new IsoValidator(); 
		isoValid1 = "2015-07-01T07:00:00Z";
		isoValid2 = "2015-07-31T23:59:59Z";
		isoInvalid1 = "2015-14-04T07:00:00Z";
		isoInvalid2 = "2015-00-04T07:00:00Z";
		isoInvalid3 = "2015-01-32T07:00:00Z";
		isoInvalid4 = "2015-07-01T26:00:00Z"; 
		isoInvalid5 = "2015-07-01T07:60:00Z"; 
		isoInvalid6 = "2015-07-01T07:00:60Z";
	}
	
	/* DaysValidator Tests */
	@Test
	public void validDates1() {
		assertTrue(daysValidator.validate(daysValid1)); 
	}
	
	@Test
	public void invalidDates1() {
		assertFalse(daysValidator.validate(daysInvalid1)); 
	}
	
	@Test 
	public void emptyDates() {
		assertFalse(daysValidator.validate(emptyString)); 
	}
	
	@Test
	public void allDates() {
		for (String day : daysAll) {
			assertTrue(daysValidator.validate(day)); 
		}
	}
	
	/* TimeValidator Tests */
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
	
	/* IsoValidator Tests */
	@Test 
	public void validIso() {
		assertTrue(isoValidator.validate(isoValid1));
		assertTrue(isoValidator.validate(isoValid2));
	}
	
	@Test 
	public void invalidIsos() {
		assertFalse(isoValidator.validate(isoInvalid1));
		assertFalse(isoValidator.validate(isoInvalid2));
		assertFalse(isoValidator.validate(isoInvalid3));
		assertFalse(isoValidator.validate(isoInvalid4));
		assertFalse(isoValidator.validate(isoInvalid5));
		assertFalse(isoValidator.validate(isoInvalid6));
	}
	
	@Test 
	public void emptyIso() {
		assertFalse(isoValidator.validate(emptyString));
	}
}
