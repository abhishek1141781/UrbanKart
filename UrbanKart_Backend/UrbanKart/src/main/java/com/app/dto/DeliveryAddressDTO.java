package com.app.dto;

public class DeliveryAddressDTO {
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;

	public DeliveryAddressDTO() {
		super();
		System.out.println("in ctor " + getClass().getName());
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAdressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public DeliveryAddressDTO(String addressLine1, String addressLine2, String city, String state, String zipCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

}
