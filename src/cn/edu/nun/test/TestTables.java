package cn.edu.nun.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.edu.nun.entity.Admin;
import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.Checkor;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Menber;
import cn.edu.nun.entity.Publisher;
import ognl.IteratorEnumeration;

public class TestTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		System.out.println(configuration);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		//管理员1
		Admin admin = new Admin();
		admin.setAge(45);
		admin.setBrief("我是一名优秀的管理员");
		admin.setEmail("manager1@qq.com");
		admin.setName("admin1");
		admin.setUsername("admin1");
		admin.setPassword("admin123");
		admin.setUsertype("admin");
		//管理员1
		Admin admin2 = new Admin();
		admin2.setAge(38);
		admin2.setBrief("我是一名优秀的管理员");
		admin2.setEmail("manager2@qq.com");
		admin2.setName("admin21");
		admin2.setUsername("admin2");
		admin2.setPassword("admin123");
		admin2.setUsertype("admin");
				
				
		//新项目1
		ItemNew itemNew = new ItemNew();
		itemNew.setItemName("大学生创新管理系统");
		itemNew.setMoney(1000);
		itemNew.setContent("飞创牛逼");
		itemNew.setPublishTime(new Date());
		//新项目2
		ItemNew itemNew2 = new ItemNew();
		itemNew2.setItemName("大学生马克思课程管理系统");
		itemNew2.setMoney(3000);
		itemNew2.setContent("让你精通马克思主义文学");
		itemNew2.setPublishTime(new Date());
		//新项目3
		ItemNew itemNew3 = new ItemNew();
		itemNew3.setItemName("库存管理系统");
		itemNew3.setMoney(1500);
		itemNew3.setContent("管理库存");
		itemNew3.setPublishTime(new Date());
		//新项目4
		ItemNew itemNew4 = new ItemNew();
		itemNew4.setItemName("火车票管理系统");
		itemNew4.setMoney(4000);
		itemNew4.setContent("买票卖票");
		itemNew4.setPublishTime(new Date());
		
		
		
		//旧项目1
		ItemOld itemOld = new ItemOld();
		itemOld.setItemName("图书馆管理系统");
		itemOld.setMoney(3500);
		itemOld.setContent("图书管理");
		itemOld.setPublishTime(new Date());
		//旧项目2
		ItemOld itemOld2 = new ItemOld();
		itemOld2.setItemName("人力资源管理系统");
		itemOld2.setMoney(500);
		itemOld2.setContent("人才管理");
		itemOld2.setPublishTime(new Date());
		//旧项目3
		ItemOld itemOld3 = new ItemOld();
		itemOld3.setItemName("物流管理系统");
		itemOld3.setMoney(1000);
		itemOld3.setContent("管理物流");
		itemOld3.setPublishTime(new Date());
		//旧项目4
		ItemOld itemOld4 = new ItemOld();
		itemOld4.setItemName("养殖场管理系统");
		itemOld4.setMoney(1000);
		itemOld4.setContent("养殖场管理鸡鸭鱼肉");
		itemOld4.setPublishTime(new Date());
		
		
		
		//发布人1
		Publisher publisher = new Publisher();
		publisher.setUsername("刘洋");
		publisher.setPassword("java1234");
		publisher.setTelephone("火警119");
		publisher.setName("刘洋");
		publisher.setEmail("123@qq.com");
		publisher.setBrief("我很棒！");
		//发布人2
		Publisher publisher2 = new Publisher();
		publisher2.setUsername("郑成功");
		publisher2.setPassword("helloworld23");
		publisher2.setTelephone("15709613570");
		publisher2.setName("郑成功");
		publisher2.setEmail("15709613570@qq.com");
		publisher2.setBrief("I'm very good !！");
		//发布人3
		Publisher publisher3 = new Publisher();
		publisher3.setUsername("季风");
		publisher3.setPassword("HTML1234");
		publisher3.setTelephone("非警119");
		publisher3.setName("刘黄");
		publisher3.setEmail("hello@qq.com");
		publisher3.setBrief("我很棒！");
		//发布人4
		Publisher publisher4 = new Publisher();
		publisher4.setUsername("柳飞");
		publisher4.setPassword("liufei");
		publisher4.setTelephone("15878348993");
		publisher4.setName("飞机");
		publisher4.setEmail("feiji@qq.com");
		publisher4.setBrief("我会飞！");
		
		//申请人1
		Applicant applicant = new Applicant();
		applicant.setUsername("毛泽东");
		applicant.setPassword("maozedong123456");
		applicant.setTelephone("15978348093");
		applicant.setName("润之");
		applicant.setEmail("maozedong@qq.com");
		applicant.setBrief("我是毛泽东！");
		//申请人2
		Applicant applicant2 = new Applicant();
		applicant2.setUsername("蒋介石");
		applicant2.setPassword("jiangjieshi123456");
		applicant2.setTelephone("16978348993");
		applicant2.setName("介石");
		applicant2.setEmail("jiangjiehsi@qq.com");
		applicant2.setBrief("我是蒋介石！");
		//申请人3
		Applicant applicant3 = new Applicant();
		applicant3.setUsername("周恩来");
		applicant3.setPassword("zhouenlai123");
		applicant3.setTelephone("16908348993");
		applicant3.setName("恩来");
		applicant2.setEmail("zhouenlai@qq.com");
		applicant3.setBrief("我是周恩来！");
		//申请人4
		Applicant applicant4 = new Applicant();
		applicant4.setUsername("林彪");
		applicant4.setPassword("linbiao123456");
		applicant4.setTelephone("15278348093");
		applicant4.setName("林彪");
		applicant4.setEmail("linbiao@qq.com");
		applicant4.setBrief("我是林彪！");
		
		//审核人1
		Checkor checkor = new Checkor();
		checkor.setUsername("审核人1");
		checkor.setPassword("123456nun");
		checkor.setUsertype("审核人");
		checkor.setTelephone("15467876547");
		checkor.setName("李白");
		checkor.setEmail("libai@qq.com");
		checkor.setBrief("我是一个烂漫主义的伟大诗人");
		
		//成员1
		Menber menber = new Menber();
		menber.setName("杜甫");
		menber.setTelephone("没有电话");
		menber.setBrief("我是一个伟大的现实主义一诗人");
		menber.setAge(30);
		//成员2
		Menber menber2 = new Menber();
		menber2.setName("柳宗元");
		menber2.setTelephone("没有电话");
		menber2.setBrief("我是一个伟大的现实主义诗人");
		menber2.setAge(40);
		
		//成员3
		Menber menber3 = new Menber();
		menber3.setName("孟浩然");
		menber3.setTelephone("没有电话");
		menber3.setBrief("我是一个伟大的田园风光诗人");
		menber3.setAge(25);
		//成员4
		Menber menber4 = new Menber();
		menber4.setName("白居易");
		menber4.setTelephone("没有电话");
		menber4.setBrief("我是一个伟大的现实主义诗人");
		menber4.setAge(50);
		
		//设置关联关系
		
		//设置发布人与新项目的关联关系
		publisher.setItemNew(itemNew);
		publisher2.setItemNew(itemNew2);
		publisher3.setItemNew(itemNew3);
		publisher4.setItemNew(itemNew4);
		
		itemNew.setPublisher(publisher);
		itemNew2.setPublisher(publisher2);
		itemNew3.setPublisher(publisher3);
		itemNew4.setPublisher(publisher4);
		
		//设置发布人与旧项目的关联关系
		
		itemOld.setPublisher(publisher);
		itemOld2.setPublisher(publisher);
		
		publisher.getItemOlds().add(itemOld);
		publisher.getItemOlds().add(itemOld2);
		
		itemOld3.setPublisher(publisher2);
		itemOld4.setPublisher(publisher2);
		
		publisher2.getItemOlds().add(itemOld3);
		publisher2.getItemOlds().add(itemOld4);
		
		//设置申请人与新项目的关联关系
		applicant.setItemNew(itemNew);
		applicant2.setItemNew(itemNew);
		applicant3.setItemNew(itemNew3);
		applicant4.setItemNew(itemNew4);
		
		itemNew.getApplicants().add(applicant);
		itemNew.getApplicants().add(applicant2);
		itemNew3.getApplicants().add(applicant3);
		itemNew4.getApplicants().add(applicant4);
		
		//设置申请人与就旧项目的关联关系
		itemOld.getApplicants().add(applicant);
		itemOld.getApplicants().add(applicant2);
		itemOld.getApplicants().add(applicant3);
		
		applicant.getItemOlds().add(itemOld);
		applicant.getItemOlds().add(itemOld2);
		applicant.getItemOlds().add(itemOld3);
		//设置申请人与成员的关系
		menber.setApplicant(applicant);
		menber2.setApplicant(applicant);
		
		applicant.getMenbers().add(menber);
		applicant.getMenbers().add(menber2);
		
		menber3.setApplicant(applicant3);
		menber4.setApplicant(applicant3);
		
		applicant3.getMenbers().add(menber3);
		applicant3.getMenbers().add(menber4);
		//设置审核人与申请人的关联关系
		checkor.getApplicants().add(applicant);
		checkor.getApplicants().add(applicant2);
		checkor.getApplicants().add(applicant3);
		
		applicant.setCheckor(checkor);
		applicant2.setCheckor(checkor);
		applicant3.setCheckor(checkor);
		//保存管理员
		session.save(admin);
		session.save(admin2);
		//保存申请人
		session.save(applicant);
		session.save(applicant2);
		session.save(applicant3);
		session.save(applicant4);
		//保存发布人
		session.save(publisher);
		session.save(publisher2);
		session.save(publisher3);
		session.save(publisher4);
		//保存审核人
		session.save(checkor);
		//保存新项目
		session.save(itemNew);
		session.save(itemNew2);
		session.save(itemNew3);
		session.save(itemNew4);
		//保存旧项目
		session.save(itemOld);
		session.save(itemOld2);
		session.save(itemOld3);
		session.save(itemOld4);
		//保存组成员
		session.save(menber);
		session.save(menber2);
		session.save(menber3);
		session.save(menber4);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
