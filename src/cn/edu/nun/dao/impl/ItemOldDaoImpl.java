package cn.edu.nun.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.edu.nun.dao.ItemOldDao;
import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Page;
import cn.edu.nun.tools.GainPage;

public class ItemOldDaoImpl implements ItemOldDao {
	
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
	public void saveItemOld(ItemOld itemOld) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(itemOld);
	}

	@Override
	public Page<ItemOld> getItemOldsByPage(Map<String, Object> queryFields, int currentPage) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Page page= null;
		String className = "cn.edu.nun.entity.ItemOld";
		GainPage gainPage = new GainPage();
		page = gainPage.getPage(queryFields, currentPage, className, session);
		return page;
	}

	@Override
	public ItemOld getItemOldById(int id) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().get(ItemOld.class, id);
	}

	@Override
	public void deleteItemOld(ItemOld itemOld) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(itemOld);
	}

	@Override
	public void deleteAllItemOlds(List<ItemOld> itemOlds) {
		// TODO Auto-generated method stub
		for (ItemOld itemOld : itemOlds) {
			this.getCurrentSession().delete(itemOld);
		}
	}

	@Override
	public void updateItemOld(ItemOld itemOld) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(itemOld);
	}

}
