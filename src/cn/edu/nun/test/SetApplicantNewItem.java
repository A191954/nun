package cn.edu.nun.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.ItemNew;

public class SetApplicantNewItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		System.out.println(configuration);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		ItemNew itemNew = session.get(ItemNew.class, 5);
		
		for(int id = 5; id <= 54; id++){
			Applicant applicant = session.get(Applicant.class, id);
			applicant.setItemNew(itemNew);
			itemNew.getApplicants().add(applicant);
			
			session.update(applicant);
			session.update(itemNew);
			
		}
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
