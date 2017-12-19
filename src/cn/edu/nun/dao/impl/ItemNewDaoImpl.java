package cn.edu.nun.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.edu.nun.dao.ItemNewDao;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.Page;
import cn.edu.nun.tools.GainPage;

public class ItemNewDaoImpl implements ItemNewDao {
	
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public void saveItemNew(ItemNew itemNew) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(itemNew);
	}

	@Override
	public Page<ItemNew> getItemNewsByPage(Map<String, Object> queryFields, int currentPage) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Page page= null;
		String className = "cn.edu.nun.entity.ItemNew";
		GainPage gainPage = new GainPage();
		page = gainPage.getPage(queryFields, currentPage, className, session);
		return page;
	}

	@Override
	public ItemNew getItemNewById(int id) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().get(ItemNew.class, id);
	}

	@Override
	public void deleteItemNew(ItemNew itemNew) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(itemNew);
	}

	@Override
	public void deleteAllItemNews(List<ItemNew> itemNews) {
		// TODO Auto-generated method stub
		for (ItemNew itemNew : itemNews) {
			this.getCurrentSession().delete(itemNew);
		}
	}

	@Override
	public void updateItemNew(ItemNew itemNew) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(itemNew);
	}

}
