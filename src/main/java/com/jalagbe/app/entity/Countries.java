package com.jalagbe.app.entity;



import com.jalagbe.app.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

@Entity
@Table(name = "countries", catalog = "jalagbe_db", uniqueConstraints = {
		@UniqueConstraint(columnNames = "COUNTRY_NAME"),
		@UniqueConstraint(columnNames = "COUNTRY_CODE")})
public class Countries extends BaseEntity implements Serializable {

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

    public Countries(String countryName, String countryCode) {
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    public Countries(Long id, String createdOn, String updatedOn, String countryName, String countryCode) {
        super(id, createdOn, updatedOn);
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

	@Override
	public String toString() {
		return "Countries [countryName="
				+ countryName + ", countryCode=" + countryCode + "]";
	}
}
