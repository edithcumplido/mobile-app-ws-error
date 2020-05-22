package com.mobile.ws.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsModelRequest {

	@NotNull(message = "Email is null")
	@Email
	private String email;
	@NotNull(message = "First name is null")
	@Size(min = 2, message = "First name must not be less than 2 characters")
	private String firstName;
	@NotNull(message = "Last name is null")
	private String lastName;
	private String userId;
	@NotNull(message = "Password is null")
	@Size(min = 8, max = 16, message = "Password must be greater than 8 and less than 16")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
