package com.kyle.parking_challenge.model;

public class Rate {
	private String days; 
	private TimeLimit timeLimit; 
	private int price;
	
	public Rate(String days, TimeLimit timeLimit, int price) {
		this.days = days; 
		this.timeLimit = timeLimit; 
		this.price = price; 
	}
	
	public Rate() {
		this.days = ""; 
		this.timeLimit = new TimeLimit(); 
		this.price = 0; 
	}
	
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public TimeLimit getTimes() {
		return timeLimit;
	}
	public void setTimes(TimeLimit timeLimit) {
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
		return days + "\n" + timeLimit.toString() + "\n" + price; 
	}
}
