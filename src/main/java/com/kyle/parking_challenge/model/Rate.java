package com.kyle.parking_challenge.model;

public class Rate {
	private String days; 
	private String timeLimit; 
	private int price;
	
	public Rate(String days, String timeLimit, int price) {
		this.days = days; 
		this.timeLimit = timeLimit; 
		this.price = price; 
	}
	
	public Rate() {
		this.days = ""; 
		this.timeLimit = "0000-0000"; 
		this.price = 0; 
	}
	
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getTimes() {
		return timeLimit;
	}
	public void setTimes(String timeLimit) {
		this.timeLimit = timeLimit;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	} 
	@Override 
	public String toString() {
		return days + "\n" + timeLimit + "\n" + price; 
	}
}
