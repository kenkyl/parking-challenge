package com.kyle.parking_challenge.model;

public class Rate {
	private String days; 
	private String times; 
	private int price;
	
	public Rate(String days, String timeLimit, int price) {
		this.days = days; 
		this.times = timeLimit; 
		this.price = price; 
	}
	
	public Rate() {
		this.days = ""; 
		this.times = ""; 
		this.price = 0; 
	}
	
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	} 
	@Override 
	public String toString() {
		return days + "\n" + times + "\n" + price; 
	}
}
