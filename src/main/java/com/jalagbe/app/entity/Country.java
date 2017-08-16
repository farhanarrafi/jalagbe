package com.jalagbe.app.entity;


import java.io.Serializable;

public class Country implements Serializable{

	private Integer countryId;
	private String countryName;
	private String countryCode;
	
	public Country(Integer countyrId) {
		super();
		this.countryId = countyrId;
	}
	
	public Country(){
		super();
	}
	public Country(Integer countryId,String countryName, String countryCode){
		this.countryId = countryId;
		this.countryCode = countryCode;
		this.countryName = countryName;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName="
				+ countryName + ", countryCode=" + countryCode + "]";
	}
}
