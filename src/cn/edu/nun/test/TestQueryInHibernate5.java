package cn.edu.nun.test;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cn.edu.nun.entity.Admin;
import cn.edu.nun.entity.Publisher;




public class TestQueryInHibernate5 {

	
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		System.out.println(configuration);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
//		Query queryCount = session.createQuery("select count(*) from Menber");
//	
//		int totalsize = ((Number)queryCount.getResultList().get(0)).intValue();
//		
//		System.out.println(totalsize);

//		Query query = session.createQuery("from Publisher where 1 = 1 and username = :username and password = :password", Publisher.class);
//		query.setParameter("username", "¡ı—Û");
//		query.setParameter("password", "java1234");
//		List<Publisher> datalist = query.getResultList();
//		
//		for (Iterator iterator = datalist.iterator(); iterator.hasNext();) {
//			Publisher publisher = (Publisher) iterator.next();
//			System.out.println(publisher.getBrief());
//			
//		}
//		Map<String, Object> queryFields = new HashMap<String, Object>();
//		queryFields.put("username", "¡ı—Û");
//		queryFields.put("password", "java1234");
//		StringBuilder hql = new StringBuilder("from Publisher where 1 = 1");
//		
//		if(queryFields != null && !queryFields.isEmpty()){
//			for(Map.Entry<String, Object> param : queryFields.entrySet()){
//				String key = param.getKey();
//				hql.append(" and " + key + " = :" + key);
//			}
//		}
//		
//		System.out.println(hql.toString());
//		Query queryList = session.createQuery(hql.toString(), Publisher.class);
//		queryList.setParameter("username", "÷£≥…π¶");
//		queryList.setParameter("password", "helloworld23");
//		Publisher publisher = (Publisher) queryList.getResultList().get(0);
//		
//		System.out.println(publisher.getBrief());
		String className = "cn.edu.nun.entity.ItemOld";//cn.edu.nun.entity.ItemOld
		Query queryCount = session.createQuery("select count(*) from ItemOld where 1 = 1", Long.class);
		int queryTotalRecords = ((Number)queryCount.getResultList().get(0)).intValue();
		System.out.println(queryTotalRecords);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
