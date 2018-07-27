package com.kyle.parking_challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyle.parking_challenge.model.*;

@Service
public class PriceCalculator implements PriceService {

	@Autowired
	RateService rateService;
	
	public int getPrice(String timeRange) {
		// TODO Auto-generated method stub
		return 0;
	}

}
