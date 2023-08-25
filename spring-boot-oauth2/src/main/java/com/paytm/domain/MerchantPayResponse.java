package com.paytm.domain;

import java.util.Date;

public class MerchantPayResponse {

	private String transactionNo;
	private Date transactionDate;
	private String paytmAccountNo;
	private String merchantAccountNo;
	private double amount;
	private String status;

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
