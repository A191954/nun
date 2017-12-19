package cn.edu.nun.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import cn.edu.nun.dao.ApplicantDao;
import cn.edu.nun.entity.AppBook;
import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Menber;
import cn.edu.nun.entity.Page;
import cn.edu.nun.tools.Constant;
import cn.edu.nun.tools.GainPage;

public class ApplicantDaoImpl implements ApplicantDao {

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
	public void saveApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(applicant);
	}

	@Override
	public Page<Applicant> getApplicantsByPage(Map<String, Object> queryFields, int currentPage) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Page page= null;
		String className = "cn.edu.nun.entity.Applicant";
		GainPage gainPage = new GainPage();
		page = gainPage.getPage(queryFields, currentPage, className, session);
		return page;
	}

	@Override
	public Applicant getApplicantById(int id) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().get(Applicant.class, id);
	}

	@Override
	public void deleteApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(applicant);
	}

	@Override
	public void deleteAllApplicants(List<Applicant> applicants) {
		// TODO Auto-generated method stub
		for (Applicant applicant : applicants) {
			this.getCurrentSession().delete(applicant);
		}
	}

	@Override
	public void updateApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(applicant);
	}

	@Override
	public int checkLogin(Applicant applicantModel) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String username = applicantModel.getUsername();
		String password = applicantModel.getPassword();
		Session session = this.getCurrentSession();
		Query query = session.createQuery("from Applicant where 1 = 1 and username = :username and password = :password", Applicant.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<Applicant> dataList = query.getResultList();
		int id = -1;
		if(dataList.size() > 0){
			id = dataList.get(0).getId();
		}
		return id;
	}
	@Override
	public Page<ItemOld> getItemOldsByApplicantId(int id, int currentPage) {
		// TODO Auto-generated method stub
		Page page = null;
		Session session = this.getCurrentSession();
		
		String listHql = "select distinct itemOld from ItemOld itemOld join itemOld.applicants applicant where applicant.id = :id";
		String countHql = "select count(distinct itemOld) from ItemOld itemOld join itemOld.applicants applicant where applicant.id = :id";
		
		Query listQuery = session.createQuery(listHql, ItemOld.class);
		Query countQuery = session.createQuery(countHql);
		
		listQuery.setParameter("id", id);
		countQuery.setParameter("id", id);
		//查询多少条
		int querySize = Constant.pageSize;
		//查询索引
		int queryIndex = (currentPage-1) * querySize;
		//查询出来的数据集
		@SuppressWarnings("unchecked")
		List<ItemOld> queryDataList = listQuery.setFirstResult(queryIndex)//
										.setMaxResults(querySize) //
										.getResultList();
		//总记录数
		int queryTotalRecords = ((Number)countQuery.getResultList().get(0)).intValue();
		//创建Page， 并初始化
//		page = new Page<>(queryTotalRecords, querySize, currentPage, queryDataList);
		page = new Page<>(queryTotalRecords, querySize, currentPage, queryDataList, Constant.startPage, Constant.endPage);
		return page;
	}
	@Override
	public void DeclareItemNew(int appId, int itemNewId) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Applicant applicant = session.get(Applicant.class, appId);
		ItemNew itemNew = session.get(ItemNew.class, itemNewId);
		
		//设置关联关系
		applicant.setItemNew(itemNew);
		itemNew.getApplicants().add(applicant);
	}
	@Override
	public void addMenber(int appId, Menber menber) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Applicant applicant = session.get(Applicant.class, appId);
		applicant.getMenbers().add(menber);
		menber.setApplicant(applicant);
		session.save(menber);
		session.update(applicant);
	}
	@Override
	public void deleteMenber(int appId, int menberId) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Applicant applicant = session.get(Applicant.class, appId);
		Menber menber = session.get(Menber.class, menberId);
		System.out.println(menber.getName());
		//解除关系
		applicant.getMenbers().remove(menber);
		session.delete(menber);
		session.flush();;
	}
	@Override
	public void updateMenber(Menber menber) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Menber updateMenber = session.get(Menber.class, menber.getId());
		//可以用java遍历属性 代替 if 判断
		if(!menber.getName().equals("")){
			String name = menber.getName();
			updateMenber.setName(name);
		}
		if(menber.getAge() != null && !menber.getAge().equals("")){
			int age = menber.getAge();
			updateMenber.setAge(age);
		}
		if(!menber.getBrief().equals("")){
			String brief = menber.getBrief();
			updateMenber.setBrief(brief);
		}
		if(!menber.getEmail().equals("")){
			String email = menber.getEmail();
			updateMenber.setEmail(email);
		}
		if(!menber.getTelephone().equals("")){
			String telephone = menber.getTelephone();
			updateMenber.setTelephone(telephone);
		}
		session.update(updateMenber);
		session.flush();
	}
	@Override
	public ItemNew findItemNew(int appId) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Applicant applicant = session.get(Applicant.class, appId);
		ItemNew itemNew = applicant.getItemNew();
		return itemNew;
	}
	@Override
	public void cancelItemNew(int appId, int itemNewId) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Applicant applicant = session.get(Applicant.class, appId);
		applicant.setChecked(false);
		applicant.setCheckedState(null);
		applicant.setCheckor(null);
		ItemNew itemNew = session.get(ItemNew.class, itemNewId);
		if(itemNew != null){
			itemNew.getApplicants().remove(applicant);
			applicant.setItemNew(null);
		}
	
		AppBook appBook = applicant.getAppBook();
		if(appBook != null){
			appBook.setApplicant(null);
			applicant.setAppBook(null);
			session.delete(appBook);
		}
	}
	@Override
	public void publishAppBook(int appId, AppBook appBook) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Applicant applicant = session.get(Applicant.class, appId);

		applicant.setAppBook(appBook);
		appBook.setApplicant(applicant);
		
		session.save(appBook);
		session.update(applicant);
	}
	@Override
	public AppBook findAppBook(int appId) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		AppBook appBook = session.get(AppBook.class, appId);
		return appBook;
	}
	
	

}
