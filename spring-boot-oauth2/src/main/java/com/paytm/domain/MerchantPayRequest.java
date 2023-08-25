package com.paytm.domain;

public class MerchantPayRequest {

	private String paytmAccountNo;
	private String merchantAccountNo;
	private double amount;
	private String description;

	public String getPaytmAccountNo() {
		return paytmAccountNo;
	}

	public void setPaytmAccountNo(String paytmAccountNo) {
		this.paytmAccountNo = paytmAccountNo;
	}

	public String getMerchantAccountNo() {
		return merchantAccountNo;
	}

	public void setMerchantAccountNo(String merchantAccountNo) {
		this.merchantAccountNo = merchantAccountNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
