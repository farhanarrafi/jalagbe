package com.jalagbe.app.dao.impl;

import com.jalagbe.app.base.dao.impl.BaseDaoImpl;
import com.jalagbe.app.dao.CategoryDao;
import com.jalagbe.app.entity.Category;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl extends BaseDaoImpl<Category, Integer> implements CategoryDao {

	public CategoryDaoImpl(SessionFactory sessionFactory){
			super(sessionFactory, Category.class);
	}

	@Override
	public List<Category> getCategory(String input) {
		return null;
	}


//	@SuppressWarnings("unchecked")
//	@Override
//	public List<CategoryModel> getCategory(String input) {
//		Session session = super.getCurrentSession();
//		Query query = session.createQuery("FROM Categorie WHERE PARENT_ID= :data");
//		query.setParameter("data", input);
//		try{
//			return query.list();
//		}
//		finally {
//			super.destroyCurrentSession(session);
//		}
//		Criteria c = session.createCriteria(CategoryModel.class);
//		c.add(Restrictions.eq("parentId", input));
//		c.add(input == null ? Restrictions.isNull("parentId") : Restrictions.eq("parentId", input));
//		return  c.list();
//	}

}
