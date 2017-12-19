package cn.edu.nun.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import cn.edu.nun.dao.PublisherDao;
import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Page;
import cn.edu.nun.entity.Publisher;
import cn.edu.nun.tools.Constant;
import cn.edu.nun.tools.GainPage;

public class PublisherDaoImpl implements PublisherDao {
	
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
	public void savePublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(publisher);
	}

	@Override
	public Page<Publisher> getPublishersByPage(Map<String, Object> queryFields, int currentPage) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Page page= null;
		String className = "cn.edu.nun.entity.Publisher";
		GainPage gainPage = new GainPage();
		page = gainPage.getPage(queryFields, currentPage, className, session);
		return page;
	}

	@Override
	public Publisher getPublisherById(int id) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().get(Publisher.class, id);
	}

	@Override
	public void deletePublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(publisher);
	}

	@Override
	public void deleteAllPublishers(List<Publisher> publishers) {
		// TODO Auto-generated method stub
		for (Publisher publisher : publishers) {
			this.getCurrentSession().delete(publisher);
		}
	}

	@Override
	public void updatePublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(publisher);
	}

	@Override
	public int checkLogin(Publisher publisherModel) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String username = publisherModel.getUsername();
		String password = publisherModel.getPassword();
		System.out.println(username + "   " + password);
		Session session = this.getCurrentSession();
		Query query = session.createQuery("from Publisher where 1 = 1 and username = :username and password = :password", Publisher.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<Publisher> dataList = query.getResultList();
		int id = -1;
		if(dataList.size() > 0){
			id = dataList.get(0).getId();
		}
		return id;
	}
	@Override
	public Page<ItemOld> findItemOld(int publisherId, int currentPage) {
		Page page = null;
		Session session = this.getCurrentSession();
		
		String listHql = "from ItemOld where PUBLISHER_ID = :id";
		String countHql = "select count(*) from ItemOld itemOld where PUBLISHER_ID = :id";
		
		Query listQuery = session.createQuery(listHql, ItemOld.class);
		Query countQuery = session.createQuery(countHql);
		
		listQuery.setParameter("id", publisherId);
		countQuery.setParameter("id", publisherId);
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
		page = new Page<>(queryTotalRecords, querySize, currentPage, queryDataList, Constant.startPage, Constant.endPage);
		
		return page;
	}
	@Override
	public void publisherAddItemNew(int publisherId, ItemNew itemNew) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Publisher publisher = session.get(Publisher.class, publisherId);
		publisher.setItemNew(itemNew);
		itemNew.setPublisher(publisher);
		session.save(itemNew);
		session.update(publisher);
		session.flush();
	}
	@Override
	public ItemNew findItemNew(int publisherId) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		Publisher publisher = session.get(Publisher.class, publisherId);
		if(publisher != null){
			System.out.println("dao 发布人的名称 ： " +publisher.getName());
		}
		ItemNew itemNew = publisher.getItemNew();
		if(itemNew != null){
			System.out.println("dao :项目名称： " + itemNew.getItemName());
		}
		return itemNew;
	}
	@Override
	public void updateItemNew(ItemNew itemNew) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSession();
		ItemNew updateItemNew = session.get(ItemNew.class, itemNew.getId());
		if(!itemNew.getItemName().equals("")){
			updateItemNew.setItemName(itemNew.getItemName());
		}
		if(!itemNew.getContent().equals("")){
			updateItemNew.setContent(itemNew.getContent());
		}
		if(itemNew.getMoney() > 0){
			updateItemNew.setMoney(itemNew.getMoney());
		}
		session.update(updateItemNew);
		session.flush();
	}
	@Override
	public Page<Applicant> findItemNewApplicant(int itemNewId, int currentPage) {
		// TODO Auto-generated method stub
		Page<Applicant> page = null;
		Session session = this.getCurrentSession();
		ItemNew itemNew =session.get(ItemNew.class, itemNewId);
		Set<Applicant> applicants = itemNew.getApplicants();
		System.out.println("dao : itemNewId " + itemNewId);
		
		List<Applicant> datalist = new ArrayList<Applicant>(0);
		for (Applicant applicant : applicants) {
			datalist.add(applicant);
		}
//		//总共多少个 申请人申请了
		int totalRecords = applicants.size();
		page = new Page<Applicant>(totalRecords, Constant.pageSize, currentPage, datalist, Constant.startPage, Constant.endPage);
		return page;
	}

}
