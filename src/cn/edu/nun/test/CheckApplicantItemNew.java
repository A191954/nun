package cn.edu.nun.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.edu.nun.entity.Applicant;

public class CheckApplicantItemNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		System.out.println(configuration);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Applicant applicant = session.get(Applicant.class, 2);
		applicant.setChecked(true);
		applicant.setCheckedState("Í¨¹ý");
		
		session.update(applicant);
		session.flush();
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
