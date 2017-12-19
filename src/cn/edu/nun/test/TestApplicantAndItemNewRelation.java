package cn.edu.nun.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Page;
import cn.edu.nun.tools.GainPage;

public class TestApplicantAndItemNewRelation {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		System.out.println(configuration);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Applicant applicant = session.get(Applicant.class, 1);
		
		ItemNew itemNew = session.get(ItemNew.class, 21);
		
		System.out.println(applicant.getUsername());
		System.out.println(applicant.getItemNew().getItemName());
		
		System.out.println(itemNew.getItemName());
		
		applicant.setItemNew(itemNew);
		itemNew.getApplicants().add(applicant);
		
		System.out.println(applicant.getItemNew().getItemName());
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
