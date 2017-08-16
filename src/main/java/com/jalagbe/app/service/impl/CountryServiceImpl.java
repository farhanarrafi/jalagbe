package com.jalagbe.app.service.impl;

import com.jalagbe.app.dao.impl.CountryDaoImpl;
import com.jalagbe.app.entity.Country;
import com.jalagbe.app.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
	private CountryDaoImpl countryDaoImpl;
	

	public CountryDaoImpl getCountryDaoImpl() {
		return countryDaoImpl;
	}

	public void setCountryDaoImpl(CountryDaoImpl countryDaoImpl) {
		this.countryDaoImpl = countryDaoImpl;
	}

	@Override
	public boolean save(Country object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Country object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Country object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Country> getAll() {
		return countryDaoImpl.getAll();
	}

	@Override
	public Country get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> getDataBy(String columnName, String input) {
		return countryDaoImpl.getDataByColumnName(columnName, input);
	}

}
