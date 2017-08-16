package com.jalagbe.app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user", catalog = "jalagbe_db")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
	private Integer id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "MOBILE", nullable = false)
    private String mobile;

    @Column(name = "BILLING_ADDRESS", nullable = false)
    private String billingAddress;

    @Column(name = "BILLING_COUNTRY", nullable = false)
    private Country billingCountry;

    @Column(name = "BILLING_CITY", nullable = false)
    private String billingCity;

    @Column(name = "BILLING_ZIP_CODE", nullable = false)
    private String billingZipCode;

    @Column(name = "SHIPPING_ADDRESS", nullable = false)
    private String shippingAddress;

    @Column(name = "SHIPPING_COUNTRY", nullable = false)
    private Country shippingCountry;

    @Column(name = "SHIPPING_CITY", nullable = false)
    private String shippingCity;

    @Column(name = "SHIPPING_ZIP_CODE", nullable = false)
    private String shippingZipCode;

    public User() {
        super();
    }

    public User(String firstName, String lastName, String email, String password, String mobile, String billingAddress, Country billingCountry, String billingCity, String billingZipCode, String shippingAddress, Country shippingCountry, String shippingCity, String shippingZipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.billingAddress = billingAddress;
        this.billingCountry = billingCountry;
        this.billingCity = billingCity;
        this.billingZipCode = billingZipCode;
        this.shippingAddress = shippingAddress;
        this.shippingCountry = shippingCountry;
        this.shippingCity = shippingCity;
        this.shippingZipCode = shippingZipCode;
    }

    public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}


	public Country getBillingCountry() {
		return billingCountry;
	}


	public void setBillingCountry(Country billingCountry) {
		this.billingCountry = billingCountry;
	}


	public String getBillingCity() {
		return billingCity;
	}


	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}


	public String getBillingZipCode() {
		return billingZipCode;
	}


	public void setBillingZipCode(String billingZipCode) {
		this.billingZipCode = billingZipCode;
	}


	public String getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	public Country getShippingCountry() {
		return shippingCountry;
	}


	public void setShippingCountry(Country shippingCountry) {
		this.shippingCountry = shippingCountry;
	}


	public String getShippingCity() {
		return shippingCity;
	}


	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}


	public String getShippingZipCode() {
		return shippingZipCode;
	}


	public void setShippingZipCode(String shippingZipCode) {
		this.shippingZipCode = shippingZipCode;
	}


	@Override
	public String toString() {
		return "Register [id=" + id + ",firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password
				+ ", mobile=" + mobile + ", billingAddress=" + billingAddress + ", "
				+ "billingCity=" + billingCity + ", billingCountry=" + billingCountry
				+ ", billingZipCode=" + billingZipCode + ", shippingAddress=" + shippingAddress
				+ ", shippingCity=" + shippingCity + ", shippingCountry=" + shippingCountry 
				+ ", shippingZipCode=" + shippingZipCode + "]";
	}
	
	
	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;
		User register = (User) object;
		if (id == null) {
			if (register.id != null)
				return false;
		} else if (!id.equals(register.id))
			return false;
		return true;
	}

}
