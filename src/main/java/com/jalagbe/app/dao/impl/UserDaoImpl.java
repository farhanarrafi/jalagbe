package com.jalagbe.app.dao.impl;

import com.jalagbe.app.base.dao.impl.BaseDaoImpl;
import com.jalagbe.app.dao.UserDao;
import com.jalagbe.app.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {
	
	public UserDaoImpl(SessionFactory sessionFactory) {
		 super(sessionFactory, User.class);
	}

	/*@Override
	public List<User> login(User user) {
		Transaction transaction = null;
		Session session = null;
		session = getCurrentSession();
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);			
		try {		
			return criteria.add(Restrictions.eq("email", user.getEmail())).list();
		} 
		finally {
			transaction.commit();
			destroyCurrentSession(session);
		}
	}*/
	
	/*public UserHibernateDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Integer register(User user) {
		System.out.println(user.getBillingAddress());
		Transaction transaction = null;
		Session session = null;
		Integer isSucess = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			isSucess = (Integer) session.save(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return isSucess;
	}

	@Override
	public List<User> getUsersList(User user) {
		Transaction transaction = null;
		Session session = null;
		session = this.sessionFactory.openSession();
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);			
		try {		
			return criteria.add(Restrictions.eq("email", user.getEmail())).list();
		} 
		finally {
			transaction.commit();
			session.close();
		}
		
	}*/

}
