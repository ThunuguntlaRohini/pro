package com.cg.paytm.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Trans {

	private String transType;
	private String to;
	private double amount;
	private LocalDate date;
	private LocalTime time;
	
	
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Trans [transType=" + transType + ", to=" + to + ", amount=" + amount + ", date=" + date + ", time="
				+ time + "]";
	}
	
	

	

}
