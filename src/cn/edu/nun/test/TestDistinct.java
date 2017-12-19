package cn.edu.nun.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cn.edu.nun.entity.ItemOld;

public class TestDistinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		System.out.println(configuration);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		// hibernate 多对多 条件查询
		String hql = "select count(distinct itemOld) from ItemOld itemOld";
		Query<?> query = session.createQuery(hql);
		int count = ((Number)query.getResultList().get(0)).intValue();
		System.out.println(count);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
