package com.jalagbe.app.dao.impl;

import com.jalagbe.app.base.dao.impl.JalagbeDaoImpl;
import com.jalagbe.app.dao.ProductImageDao;
import com.jalagbe.app.entity.ProductImage;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by rahma on 9/10/2017.
 */
@Repository
public class ProductImageDaoImpl extends JalagbeDaoImpl<ProductImage, Integer> implements ProductImageDao {
    public ProductImageDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, ProductImage.class);
    }
}
