package com.kyle.parking_challenge.model;

import java.util.Date;

public class TimeLimit {
	private Date startTime;
	private Date endTime;
	
	public TimeLimit(Date startTime, Date endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public TimeLimit() {
		this.startTime = new Date(); 
		this.endTime = new Date(); 
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndtime() {
		return endTime;
	}
	public void setEndtime(Date endtime) {
		this.endTime = endtime;
	} 
	@Override 
	public String toString() {
		return startTime.toString() + " - " + endTime.toString(); 
	}
}
