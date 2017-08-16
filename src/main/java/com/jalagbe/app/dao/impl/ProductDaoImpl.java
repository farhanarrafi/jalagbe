package com.jalagbe.app.dao.impl;

import com.jalagbe.app.base.dao.impl.BaseDaoImpl;
import com.jalagbe.app.dao.ProductDao;
import com.jalagbe.app.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product, Integer> implements ProductDao {

	public ProductDaoImpl(SessionFactory sessionFactory){
		super(sessionFactory, Product.class);
	}

}
