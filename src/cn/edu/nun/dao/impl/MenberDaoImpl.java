package cn.edu.nun.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sun.swing.internal.plaf.metal.resources.metal;

import cn.edu.nun.dao.MenberDao;
import cn.edu.nun.entity.Menber;
import cn.edu.nun.entity.Page;
import cn.edu.nun.tools.GainPage;

public class MenberDaoImpl implements MenberDao {
	
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
	public void saveMenber(Menber menber) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(menber);
	}

	@Override
	public Page<Menber> getMenbersByPage(Map<String, Object> queryFields, int currentPage) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Page page= null;
		String className = "cn.edu.nun.entity.Menber";
		GainPage gainPage = new GainPage();
		page = gainPage.getPage(queryFields, currentPage, className, session);
		return page;
	}

	@Override
	public Menber getMenberById(int id) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().get(Menber.class, id);
	}

	@Override
	public void deleteMenber(Menber menber) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(menber);
	}

	@Override
	public void deleteAllMenbers(List<Menber> menbers) {
		// TODO Auto-generated method stub
		for (Menber menber : menbers) {
			this.getCurrentSession().delete(menber);
		}
	}

	@Override
	public void updateMenber(Menber menber) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(menber);
	}

}
