package com.kyle.parking_challenge.model;

public class TimeRange {
	private String start;
	private String end;
	
	public TimeRange(String startTime, String endTime) {
		this.start = startTime;
		this.end = endTime;
	}
	public TimeRange() {
		this.start = ""; 
		this.end = ""; 
	}
	
	public String getStartTime() {
		return start;
	}
	public void setStartTime(String startTime) {
		this.start = startTime;
	}
	public String getEndtime() {
		return end;
	}
	public void setEndtime(String endtime) {
		this.end = endtime;
	} 
	@Override 
	public String toString() {
		return start + " - " + end; 
	}
}
