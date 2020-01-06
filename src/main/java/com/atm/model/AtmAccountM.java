package com.atm.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accountAtm")
public class AtmAccountM {

	private String id;
	private String numberAccountSource;
	private int maxOfMovement;
	private int numberOfMovement;
	private String createdAt;
	private String status;
	
	public AtmAccountM() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss"); 
	    this.createdAt = formatter.format(new Date());
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumberAccountSource() {
		return numberAccountSource;
	}
	public void setNumberAccountSource(String numberAccountSource) {
		this.numberAccountSource = numberAccountSource;
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
