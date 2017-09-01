package com.ankush.mavenshop.model;

import javax.validation.constraints.Size;

public class WorldTest {

	@Size(min=2, max=30) 
	private String state;
	
	
	@Size(min=2, max=30) 
	private String country;
	
	@Size(min=6, max=6,message = "Please enter six digit pin code.")
	private String pinCode;

	public WorldTest( String state, String country, String  pinCode) {
		super();
	
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
	}

	public WorldTest() {
		super();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String  getPinCode() {
		return pinCode;
	}

	public void setPinCode(String  pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "WorldTest [ state=" + state + ", country=" + country + ", pinCode=" + pinCode + "]";
	}
	
	

}
