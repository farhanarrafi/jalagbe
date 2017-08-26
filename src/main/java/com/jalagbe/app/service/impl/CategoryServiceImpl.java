package com.jalagbe.app.service.impl;


import com.jalagbe.app.dao.CategoryDao;
import com.jalagbe.app.entity.Category;
import com.jalagbe.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public List<Category> getCategory(String input) {
		return null;
	}

	@Override
	public boolean save(Category object)  throws Exception{
		return categoryDao.insert(object);
	}

	@Override
	public boolean delete(Category object) {
		return false;
	}

	@Override
	public boolean update(Category object) {
		return false;
	}

	@Override
	public List<Category> getAll() {
		return null;
	}

	@Override
	public Category get(Integer id) {
		return null;
	}

	@Override
	public List<Category> getDataBy(String columnName, String input) {
		return null;
	}
}
