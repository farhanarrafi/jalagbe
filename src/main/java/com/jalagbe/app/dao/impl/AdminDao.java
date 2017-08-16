package com.jalagbe.app.dao.impl;

import com.jalagbe.app.base.dao.impl.BaseDaoImpl;
import com.jalagbe.app.entity.Admin;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by rahma on 8/14/2017.
 */

public class AdminDao extends BaseDaoImpl<Admin, Integer> implements com.jalagbe.app.dao.AdminDao {

    public AdminDao(SessionFactory sessionFactory, Class<Admin> classType) {
        super(sessionFactory, classType);
    }
}
