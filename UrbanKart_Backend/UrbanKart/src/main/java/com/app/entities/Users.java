package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Valid
@Entity
@Table(name = "users")
public class Users extends BaseEntity{
	
	@Column(name="first_name" ,length = 25)
	@NotBlank(message = "Fist Name should Not be Blank")
	private String firstName;
	
	@Column(name="last_name" ,length = 25)
	@NotBlank(message = "Last Name should Not be Blank")
	private String lastName;
	
	@Column(name="email" ,length = 50,unique = true,nullable = false)
	@Email(message = "Email should be Proper")
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name="password" ,length = 300, nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role" ,length = 15)
	private Role role; 
	
	@Column(length=10,nullable = false)
	@Pattern(regexp="(^[0-9]{10}$)",message = "Invalid Mobile Number !")
	private String mobileNumber;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private Carts cart;
	
	public Users() {
		super();
		System.out.println("in ctor " + getClass().getName());
	}


	public Users(String firstName, String lastName, String email, String password, Role role, String mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.mobileNumber = mobileNumber;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public String getmobileNumber() {
		return mobileNumber;
	}


	public void setmobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	

	public Carts getCart() {
		return cart;
	}


	public void setCart(Carts cart) {
		this.cart = cart;
	}


	@Override
	public String toString() {
		return "Users [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", role=" + role + ", mobileNumber=" + mobileNumber + ", getId()=" + getId() + "]";
	}
	
	
	
	
	

}
