package cn.edu.nun.test;

import java.util.List;

import javax.crypto.AEADBadTagException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.jdbc.ClobProxy;

import com.mysql.jdbc.Clob;

import cn.edu.nun.entity.AppBook;
import cn.edu.nun.entity.Applicant;

public class AddApplicant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		System.out.println(configuration);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		AppBook appBook = new AppBook();
		appBook.setTextBody(ClobProxy.generateProxy("hello"));
		
		Applicant applicant = session.get(Applicant.class, 1);
		
		
		applicant.setAppBook(appBook);
		
		appBook.setApplicant(applicant);
		
		session.save(appBook);
		session.update(applicant);
//		System.out.println(applicant.getAppBook().getId());
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
