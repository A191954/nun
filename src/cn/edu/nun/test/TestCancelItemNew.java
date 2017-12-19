package cn.edu.nun.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.Menber;

public class TestCancelItemNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		System.out.println(configuration);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		
		Applicant applicant = session.get(Applicant.class, 1);
		ItemNew itemNew = session.get(ItemNew.class, 8);
		itemNew.getApplicants().remove(applicant);
		applicant.setItemNew(null);
		
		
		
		session.flush();
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
