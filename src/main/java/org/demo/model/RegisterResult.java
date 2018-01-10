package org.demo.model;

public class RegisterResult {

	private final String status;
	private final String orderRef;
	private final Double fee;

	public RegisterResult(String status, String orderRef, Double fee) {
		this.status = status;
		this.orderRef = orderRef;
		this.fee = fee;
	}

	public String getStatus() {
		return status;
	}

	public String getOrderRef() {
		return orderRef;
	}

	public Double getFee() {
		return fee;
	}
	
}
