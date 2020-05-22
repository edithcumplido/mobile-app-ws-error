package com.mobile.ws.model.response;

import java.time.LocalDateTime;

public class ErrorMessage {
	private LocalDateTime date;
	private String message;	
	

	public ErrorMessage(LocalDateTime date, String message) {
		this.date = date;
		this.message = message;
	}

	public ErrorMessage() {
		
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
