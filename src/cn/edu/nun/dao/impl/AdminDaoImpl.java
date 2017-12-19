package cn.edu.nun.dao.impl;

import java.util.List;
import java.util.Map;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import cn.edu.nun.dao.AdminDao;
import cn.edu.nun.entity.Admin;
import cn.edu.nun.entity.Page;
import cn.edu.nun.tools.GainPage;

public class AdminDaoImpl implements AdminDao {

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
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(admin);
	}

	@Override
	public Page<Admin> getAdminsByPage(Map<String, Object> queryFields, int currentPage) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Page page = null;
		GainPage gainPage = new GainPage();
		String className = "cn.edu.nun.entity.Admin";
		page = gainPage.getPage(queryFields, currentPage, className, session);
		return page;
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().get(Admin.class, id);
	}

	@Override
	public void deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(admin);
	}

	@Override
	public void deleteAllAdmins(List<Admin> admins) {
		// TODO Auto-generated method stub
		for (Admin admin : admins) {
			this.getCurrentSession().delete(admin);
		}
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(admin);
	}

	@Override
	public int checkLogin(Admin adminModel) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String username = adminModel.getUsername();
		String password = adminModel.getPassword();
		Session session = this.getCurrentSession();
		Query query = session.createQuery("from Admin where 1 = 1 and username = :username and password = :password", Admin.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		@SuppressWarnings("unchecked")
		List<Admin> dataList = query.getResultList();
		int id = -1;
		if(dataList.size() > 0){
			id = dataList.get(0).getId();
		}
		
		return id;
	}

}
