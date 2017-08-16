package com.jalagbe.app.dao;


import com.jalagbe.app.base.dao.BaseDao;
import com.jalagbe.app.entity.Category;

import java.util.List;

public interface CategoryDao extends BaseDao<Category, Integer> {
	List<Category> getCategory(String input);
}
