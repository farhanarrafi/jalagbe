package com.jalagbe.app.dao.impl;

import com.jalagbe.app.base.dao.impl.JalagbeDaoImpl;
import com.jalagbe.app.dao.CategoryImageDao;
import com.jalagbe.app.entity.CategoryImage;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by rahma on 8/27/2017.
 */

@Repository
public class CategoryImageDaoImpl extends JalagbeDaoImpl<CategoryImage, Integer> implements CategoryImageDao {

    public CategoryImageDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, CategoryImage.class);
    }
}
