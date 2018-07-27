package com.kyle.parking_challenge;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.kyle.parking_challenge.model.TimeRange;
import com.kyle.parking_challenge.service.PriceService;
import com.kyle.parking_challenge.spring.ServiceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ServiceConfig.class, loader=AnnotationConfigContextLoader.class)
public class PriceServiceTest {

	@Autowired
	PriceService priceService; 
	TimeRange timeRange1, timeRange2, timeRange3; 
	
	@Before 
	public void setup() {
		timeRange1 = new TimeRange("2015-07-01T07:00:00Z","2015-07-01T12:00:00Z");
		timeRange2 = new TimeRange("2015-07-01T07:00:00Z","2015-fail!");
		timeRange3 = new TimeRange("2015-07-01T12:00:00Z","2015-07-01T07:00:00Z");
	}
	
	@Test
	public void testValid() {
		assertEquals(true,priceService.getPrice(timeRange1.toString())>=0);
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
