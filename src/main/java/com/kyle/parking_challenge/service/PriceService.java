package com.kyle.parking_challenge.service;

import com.kyle.parking_challenge.ValidateException;

public interface PriceService {
	public int getPrice(String timeRange) throws ValidateException; 
}
