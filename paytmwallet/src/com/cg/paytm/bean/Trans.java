package com.cg.paytm.bean;

import java.time.LocalDateTime;

public class Trans {

	private String transType;
	private String to;
	private double amount;
	private LocalDateTime date;
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
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
	@Override
	public String toString() {
		return "Trans [ transType=" + transType + ", to=" + to + ", amount=" + amount
				+ ", date=" + date + "]";
	}

	

}
