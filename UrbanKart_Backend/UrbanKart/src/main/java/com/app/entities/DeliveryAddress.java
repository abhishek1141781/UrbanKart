package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Valid
@Entity
@Table(name="delivery_address")
public class DeliveryAddress extends BaseEntity{
	
	@Column(length = 50,nullable = false)
	@NotBlank(message = "Address cannot be Blank")
	private String adressLine1;
	
	@Column(length = 50,nullable = false)
	private String adressLine2;
	
	@Column(length = 50,nullable = false)
	@NotBlank(message = "City cannot be Blank")
	private String city;
	
	@Column(length = 50,nullable = false)
	@NotBlank(message = "State cannot be Blank")
	private String state;
	
	@Column(length = 50,nullable = false)
	@Size(min=6,max=8)
	private String zipCode;

	public DeliveryAddress() {
		super();
		System.out.println("in ctor "+getClass().getName());
	}

	public DeliveryAddress(String adressLine1, String adressLine2, String city, String state, String zipCode) {
		super();
		this.adressLine1 = adressLine1;
		this.adressLine2 = adressLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		}

	public String getAdressLine1() {
		return adressLine1;
	}

	public void setAdressLine1(String adressLine1) {
		this.adressLine1 = adressLine1;
	}

	public String getAdressLine2() {
		return adressLine2;
	}

	public void setAdressLine2(String adressLine2) {
		this.adressLine2 = adressLine2;
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

//	public Orders getOrderInfo() {
//		return orderInfo;
//	}
//
//	public void setOrderInfo(Orders orderInfo) {
//		this.orderInfo = orderInfo;
//	}
	
	

}
