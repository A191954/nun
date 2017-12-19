package cn.edu.nun.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import cn.edu.nun.dao.CheckorDao;
import cn.edu.nun.entity.Admin;
import cn.edu.nun.entity.AppBook;
import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.Checkor;
import cn.edu.nun.entity.Page;
import cn.edu.nun.tools.Constant;
import cn.edu.nun.tools.GainPage;

public class CheckorDaoImpl implements CheckorDao {
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
	public void saveCheckor(Checkor checkor) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(checkor);
	}

	@Override
	public Page<Checkor> getCheckorsByPage(Map<String, Object> queryFields, int currentPage) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Page page= null;
		String className = "cn.edu.nun.entity.Checkor";
		GainPage gainPage = new GainPage();
		page = gainPage.getPage(queryFields, currentPage, className, session);
		return page;
	}

	@Override
	public Checkor getCheckorById(int id) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().get(Checkor.class, id);
	}

	@Override
	public void deleteCheckor(Checkor checkor) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(checkor);
	}

	@Override
	public void deleteAllCheckors(List<Checkor> checkors) {
		// TODO Auto-generated method stub
		for (Checkor checkor : checkors) {
			this.getCurrentSession().delete(checkor);
		}
	}

	@Override
	public void updateCheckor(Checkor checkor) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(checkor);
	}

	@Override
	public int checkLogin(Checkor checkorModel) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String username = checkorModel.getUsername();
		String password = checkorModel.getPassword();
		Session session = this.getCurrentSession();
		Query query = session.createQuery("from Checkor where 1 = 1 and username = :username and password = :password", Checkor.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<Checkor> dataList = query.getResultList();
		int id = -1;
		if(dataList.size() > 0){
			id = dataList.get(0).getId();
		}
		return id;
	}
	@Override
	public Page<Applicant> findPublishItemNewApplicantsByPage(int currentPage) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getCurrentSession().createCriteria(Applicant.class);
		criteria.add(Restrictions.isNotNull("itemNew"));
		criteria.add(Restrictions.eq("isChecked", false));
		int totalRecords = criteria.list().size();
		
		//查询多少条
		int querySize = Constant.pageSize;
		//查询索引
		int queryIndex = (currentPage-1) * querySize;
		criteria.setFirstResult(queryIndex);
		criteria.setMaxResults(querySize);
		List<Applicant> datalist = criteria.list();
		
		Page<Applicant> page = new Page<Applicant>(totalRecords, Constant.pageSize, currentPage, datalist, Constant.startPage, Constant.endPage);
		return page;
	}
	@Override
	public void checkApplicantItemNew(int checkorId, int appId, String checkedState, String noPassReason) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Applicant applicant = session.get(Applicant.class, appId);
		Checkor checkor = session.get(Checkor.class, checkorId);
		//设置关联关系
		applicant.setCheckor(checkor);
		checkor.getApplicants().add(applicant);
		//debug
		System.out.println("checkApplicantItemNew  =---------");
		System.out.println("appId = " + appId);
		//已审核
		applicant.setChecked(true);
		//审核结果
		if(checkedState.equals("true")){
			applicant.setCheckedState("通过");
		}
		if(checkedState.equals("false")){
			applicant.setCheckedState("未通过");
		}
		//没通过 设置没通过理由
		if(!noPassReason.equals("") && noPassReason != null){
			applicant.setNoPassReason(noPassReason);
		}
		session.update(applicant);
		session.flush();
	}
	@Override
	public Page<Applicant> findCheckedApplicantByCheckor(int checkorId, int currentPage) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getCurrentSession().createCriteria(Applicant.class);
		criteria.add(Restrictions.eq("isChecked", true));
		criteria.add(Restrictions.eq("checkor.id", checkorId));
		int totalRecords = criteria.list().size();
		//查询多少条
		int querySize = Constant.pageSize;
		//查询索引
		int queryIndex = (currentPage-1) * querySize;
		criteria.setFirstResult(queryIndex);
		criteria.setMaxResults(querySize);
		
		List<Applicant> datalist = criteria.list();
		
		Page<Applicant> page = new Page<Applicant>(totalRecords, Constant.pageSize, currentPage, datalist, Constant.startPage, Constant.endPage);
		return page;
	}
	@Override
	public AppBook findAppBook(int appId) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().get(AppBook.class, appId);
	}

}
