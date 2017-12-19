package cn.edu.nun.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.ItemNew;

public class DeleteMenber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		System.out.println(configuration);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		ItemNew itemNew =session.get(ItemNew.class, 2);
		Set<Applicant> applicants = itemNew.getApplicants();
		System.out.println(itemNew.getItemName());
		
		System.out.println("size : " + applicants.size());
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
