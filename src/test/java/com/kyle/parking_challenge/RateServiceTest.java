package com.kyle.parking_challenge;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.kyle.parking_challenge.model.*;
import com.kyle.parking_challenge.service.*;

public class RateServiceTest {
	
	// declare objects for RateService testing
	RateService rateService; 
	String days1; 
	String days2;
	String timeLimit1; 
	Rate rate1; 
	Rate rate2; 
	List<Rate> sampleList; 
	int price1;
	int price2;
	
	@Before 
	public void setup() {
		// instantiate objects for testing
		rateService = new RateManager(); 
		days1 = "mon,tues"; 
		days2 = "wed,thurs,fri"; 
		price1 = 1000; 
		price2 = 1500; 
		timeLimit1 = "0000-0000"; 
		rate1 = new Rate(days1, timeLimit1, price1);
		rate2 = new Rate(days2, timeLimit1, price2);
		sampleList = new ArrayList<Rate>();
		sampleList.add(rate1);
		sampleList.add(rate2); 
	}
	
	@Test
	public void addRate() {
		rateService.setCurrentRates(rate1);
		assertEquals(rate1, rateService.getCurrentRates().get(0));
	}
	
	@Test 
	public void addRateList() {
		rateService.setCurrentRates(sampleList);
		assertEquals(sampleList, rateService.getCurrentRates()); 
	}
	
	@Test 
	public void clearRates() {
		rateService.setCurrentRates(sampleList);
		rateService.clearRates();
		assertEquals(0,rateService.getCurrentRates().size()); 
	}
}
