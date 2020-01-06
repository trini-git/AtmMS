package com.atm.model;

public class MainModel {
	
	private String id;
	private String accountNumber;	
	private String type;
	private double startingAmount;
	private double currentAmount;
	private double finalMonthAmount;
	private double chargeAmount;
	private int maxOfMovement;
	private int numberOfMovement;
	private String status;
	private String createdAt;
	private Bank bank;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getStartingAmount() {
		return startingAmount;
	}
	public void setStartingAmount(double startingAmount) {
		this.startingAmount = startingAmount;
	}
	public double getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(double currentAmount) {
		this.currentAmount = currentAmount;
	}
	public double getFinalMonthAmount() {
		return finalMonthAmount;
	}
	public void setFinalMonthAmount(double finalMonthAmount) {
		this.finalMonthAmount = finalMonthAmount;
	}
	public double getChargeAmount() {
		return chargeAmount;
	}
	public void setChargeAmount(double chargeAmount) {
		this.chargeAmount = chargeAmount;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}	
}
