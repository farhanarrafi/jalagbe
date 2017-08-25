package com.jalagbe.app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "countries", catalog = "jalagbe_db", uniqueConstraints = {
		@UniqueConstraint(columnNames = "COUNTRY_NAME"),
		@UniqueConstraint(columnNames = "COUNTRY_CODE")})
public class Countries implements Serializable {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "countries_seq", sequenceName = "countries_seq", allocationSize    = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countries_seq")
	private Long id;

	@Column(name = "CREATED_ON", nullable = false)
	private String createdOn;

	@Column(name = "UPDATED_ON",  nullable = false)
	private String updatedOn;
	
    @Column(name = "COUNTRY_NAME", unique = true, nullable = false)
	private String countryName;

    @Column(name = "COUNTRY_CODE", unique = true, nullable = false)
	private String countryCode;
	
	public Countries(Integer countyrId) {
		super();
	}
	
	public Countries(){
		super();
	}

	public Countries(Long id, String createdOn, String updatedOn, String countryName, String countryCode) {
		this.id = id;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.countryName = countryName;
        this.countryCode = countryCode;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "Countries [countryName="
				+ countryName + ", countryCode=" + countryCode + "]";
	}
}
