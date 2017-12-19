package cn.edu.nun.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;

import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.Page;
import cn.edu.nun.tools.Constant;

public class FindAllPublishItemNewApplicants {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		System.out.println(configuration);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Applicant.class);
		criteria.add(Restrictions.isNotNull("itemNew"));
		criteria.add(Restrictions.eq("isChecked", true));
		List<Applicant> datalist = criteria.list();
		
		System.out.println("datalist.size: " + datalist.size());
		System.out.println("申请人用户名： " + datalist.get(0).getUsername());
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
