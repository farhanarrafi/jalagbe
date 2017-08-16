package com.jalagbe.app.base.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.jalagbe.app.base.dao.BaseDao;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class BaseDaoImpl<T, PK extends Serializable> extends HibernateTemplate  implements BaseDao<T, PK> {
	//private final Logger logger = Logger.getLogger(BaseDaoImpl.class);
	private Transaction transaction = null;
	private Class<T> classType;
	private SessionFactory sessionFactory;
	private Session session = null;

    public BaseDaoImpl(SessionFactory sessionFactory, Class<T> classType) {
        super.setSessionFactory(sessionFactory);
        this.classType = classType;
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession() {
        return sessionFactory.openSession();
    }

    protected void destroyCurrentSession(Session session){
        session.close();
    }
	
	@Override
	public boolean insert(T object) {
		session = getCurrentSession();	
		transaction = session.beginTransaction();
		try {
			if((Integer) session.save(object) == 1) {
                transaction.commit();
                return true;
            }
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

        return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(PK id) {
		T result = (T) getCurrentSession().get(classType, id);
        if (result == null) {
            return null;
        }

        if (result instanceof HibernateProxy) {
            Hibernate.initialize(result);
            result = (T) ((HibernateProxy) result).getHibernateLazyInitializer().getImplementation();
        }

        return result;
	}

	@Override
	public List<T> getAll() {
		try{
			session = getCurrentSession();
            CriteriaQuery<T> criteriaQuery = session.getCriteriaBuilder().createQuery(classType);
			return session.createQuery(criteriaQuery).getResultList();
		}catch (Exception ex){
            ex.printStackTrace();
        }finally{
			destroyCurrentSession(session);
		}

		return null;
	}

	@Override
	public boolean updateTableData(T object) {
		try{
//			session = getCurrentSession();
//			session.merge(object);
            super.update(object);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }finally{
        	destroyCurrentSession(session);
        }
        return false;
	}

	@Override
	public boolean deleteTableData(T object) {
		try{
//			session = getCurrentSession();
//			session.delete(object);
            super.delete(object);
	        return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			destroyCurrentSession(session);
		}
		return false;
	}
	
	@Override
	public List<T> getDataByColumnName(String columnName, String value) {
		session = getCurrentSession();
		transaction = session.beginTransaction();

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<String> criteria = builder.createQuery( String.class );
            Root<T> root = criteria.from(classType);
            criteria.select( root.get(columnName) );
            criteria.where( builder.equal( root.get(columnName), value ) );

            session.createQuery( criteria ).getResultList();
		} catch(Exception ex) {
            ex.printStackTrace();
        }
		finally {
			transaction.commit();
			destroyCurrentSession(session);
		}
		return null;
	}

}
