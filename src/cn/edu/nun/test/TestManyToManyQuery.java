package cn.edu.nun.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import cn.edu.nun.entity.ItemOld;

public class TestManyToManyQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		System.out.println(configuration);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		// hibernate 多对多 条件查询
		String hql = "select distinct itemOld from ItemOld itemOld join itemOld.applicants applicant where applicant.id = :id";
		List<ItemOld> itemolds = session.createQuery(hql, ItemOld.class).setParameter("id", 2).getResultList();
		for (ItemOld itemOld : itemolds) {
			System.out.println(itemOld.getItemName());
		}
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
