package com.jalagbe.app.service.impl;

import com.jalagbe.app.dao.ProductDao;
import com.jalagbe.app.entity.Product;
import com.jalagbe.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;

	@Override
	public boolean save(Product object) throws Exception {
		return productDao.insert(object);
	}

	@Override
	public boolean delete(Product object) throws Exception {
		return false;
	}

	@Override
	public boolean update(Product object) throws Exception {
		return false;
	}

	@Override
	public List<Product> getAll() throws Exception {
		return null;
	}

	@Override
	public Product get(Integer id) throws Exception {
		return null;
	}

	@Override
	public List<Product> getDataBy(String columnName, String input) throws Exception {
		return null;
	}

//	@Override
//	public boolean save(Product object) {
//		return productDao.insert(object);
//	}
//
//	@Override
//	public boolean delete(Product object) {
//		return productDao.deleteTableData(object);
//	}
//
//	@Override
//	public boolean update(Product object) {
//		return productDao.updateTableData(object);
//	}
//
//	@Override
//	public List<Product> getAll() {
//		return productDao.getAll();
//	}
//
//	@Override
//	public Product get(Integer id) {
//		return null;
//	}
//
//	@Override
//	public List<Product> getDataBy(String columnName, String input) {
//		return productDao.getDataByColumnName(columnName, input);
//	}

}
