package com.kyle.parking_challenge;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.kyle.parking_challenge.model.Rate;
import com.kyle.parking_challenge.model.RateList;
import com.kyle.parking_challenge.model.TimeRange;
import com.kyle.parking_challenge.service.PriceService;
import com.kyle.parking_challenge.service.RateService;
import com.kyle.parking_challenge.spring.ServiceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ServiceConfig.class, loader=AnnotationConfigContextLoader.class)
public class PriceServiceTest {

	@Autowired
	PriceService priceService; 
	@Autowired
	RateService rateService; 
	TimeRange timeRange1, timeRange2, timeRange3; 
	RateList rateList; 
	List<Rate> rates; 
	Rate rate1, rate2; 
	
	@Before 
	public void setup() {
		timeRange1 = new TimeRange("2015-07-01T07:00:00Z","2015-07-01T12:00:00Z");
		timeRange2 = new TimeRange("2015-07-01T07:00:00Z","2015-fail!");
		timeRange3 = new TimeRange("2015-07-01T12:00:00Z","2015-07-01T07:00:00Z");
		rate1 = new Rate("mon,tues,wed,thurs,fri", "0600-1800", 1500);
		rate2 = new Rate("sat,sun", "0600-2000", 2000);
		rates = new ArrayList<Rate>(); 
		rates.add(rate2);
		rates.add(rate1);
		rateList = new RateList(rates); 
	}
	
	@Test
	public void testValid() {
		rateService.setRateList(rateList);
		assertEquals("1500",priceService.getPrice(timeRange1.toString()));
	}

	@Test(expected=ValidateException.class)
	public void testInvalid() {
		priceService.getPrice(timeRange2.toString());		 
	}
	
	@Test(expected=ValidateException.class)
	public void testInvalid2() {
		priceService.getPrice(timeRange3.toString());		 
	}
	
}
