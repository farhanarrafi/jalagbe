package com.jalagbe.app.dao;


import com.jalagbe.app.base.dao.JalagbeDao;
import com.jalagbe.app.entity.Category;

import java.util.List;

public interface CategoryDao extends JalagbeDao<Category, Integer> {
	List<Category> getCategory(String input);
}
