package com.kyle.parking_challenge.model;

import java.util.Date;

public class TimeLimit {
	private Date startTime;
	private Date endtime;
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	} 
}
