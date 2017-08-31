package com.jalagbe.app.dao.impl;

import com.jalagbe.app.base.dao.impl.JalagbeDaoImpl;
import com.jalagbe.app.dao.CountryDao;
import com.jalagbe.app.entity.Country;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDaoImpl extends JalagbeDaoImpl<Country, Integer> implements CountryDao {
	
	public CountryDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory, Country.class);
	}

	//private SessionFactory sessionFactory;

	
//
//	@Override
//	public List<Countries> getAllCountry() {
//		Transaction transaction = null;
//		Session session = null;
//		session = this.sessionFactory.openSession();
//		transaction = session.beginTransaction();
//		try {
//			List countries= session.createQuery("from Countries").list();
//			return countries;
//		} finally {
//			transaction.commit();
//			session.close();
//		}
//	}

}
