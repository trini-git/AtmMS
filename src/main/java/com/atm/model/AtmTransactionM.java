package com.atm.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "atm")
public class AtmTransactionM {
	
	private String id;
	private String bankAtm; //What bank is
	private String accountNumberSource;
	private String bankSource;
	private Double beforeAmount;
	private String type;
	private Double amount;
	private Double afterAmount;
	private Double chargeMovement;
	private Double chargeBank;
	private int maxOfMovement;
	private int numberOfMovement;
	private String createdAt;
	private String status;
	
	public AtmTransactionM() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss"); 
	    this.createdAt = formatter.format(new Date());
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBankAtm() {
		return bankAtm;
	}
	public void setBankAtm(String bankAtm) {
		this.bankAtm = bankAtm;
	}
	public String getAccountNumberSource() {
		return accountNumberSource;
	}
	public void setAccountNumberSource(String accountNumberSource) {
		this.accountNumberSource = accountNumberSource;
	}
	public String getBankSource() {
		return bankSource;
	}
	public void setBankSource(String bankSource) {
		this.bankSource = bankSource;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getBeforeAmount() {
		return beforeAmount;
	}
	public void setBeforeAmount(Double beforeAmount) {
		this.beforeAmount = beforeAmount;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getAfterAmount() {
		return afterAmount;
	}
	public void setAfterAmount(Double afterAmount) {
		this.afterAmount = afterAmount;
	}
	public Double getChargeMovement() {
		return chargeMovement;
	}
	public void setChargeMovement(Double chargeMovement) {
		this.chargeMovement = chargeMovement;
	}
	public Double getChargeBank() {
		return chargeBank;
	}
	public void setChargeBank(Double chargeBank) {
		this.chargeBank = chargeBank;
	}
	public int getMaxOfMovement() {
		return maxOfMovement;
	}
	public void setMaxOfMovement(int maxOfMovement) {
		this.maxOfMovement = maxOfMovement;
	}
	public int getNumberOfMovement() {
		return numberOfMovement;
	}
	public void setNumberOfMovement(int numberOfMovement) {
		this.numberOfMovement = numberOfMovement;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
		
}
