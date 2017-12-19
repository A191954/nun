package cn.edu.nun.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.Menber;

public class UpdateMenber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		System.out.println(configuration);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Menber menber = new Menber();
		menber.setId(5);
		menber.setName("HelloWorld");
		menber.setApplicant(null);
		session.update(menber);
		session.flush();
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
