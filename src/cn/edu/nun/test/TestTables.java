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
		
		//����Ա1
		Admin admin = new Admin();
		admin.setAge(45);
		admin.setBrief("����һ������Ĺ���Ա");
		admin.setEmail("manager1@qq.com");
		admin.setName("admin1");
		admin.setUsername("admin1");
		admin.setPassword("admin123");
		admin.setUsertype("admin");
		//����Ա1
		Admin admin2 = new Admin();
		admin2.setAge(38);
		admin2.setBrief("����һ������Ĺ���Ա");
		admin2.setEmail("manager2@qq.com");
		admin2.setName("admin21");
		admin2.setUsername("admin2");
		admin2.setPassword("admin123");
		admin2.setUsertype("admin");
				
				
		//����Ŀ1
		ItemNew itemNew = new ItemNew();
		itemNew.setItemName("��ѧ�����¹���ϵͳ");
		itemNew.setMoney(1000);
		itemNew.setContent("�ɴ�ţ��");
		itemNew.setPublishTime(new Date());
		//����Ŀ2
		ItemNew itemNew2 = new ItemNew();
		itemNew2.setItemName("��ѧ�����˼�γ̹���ϵͳ");
		itemNew2.setMoney(3000);
		itemNew2.setContent("���㾫ͨ���˼������ѧ");
		itemNew2.setPublishTime(new Date());
		//����Ŀ3
		ItemNew itemNew3 = new ItemNew();
		itemNew3.setItemName("������ϵͳ");
		itemNew3.setMoney(1500);
		itemNew3.setContent("������");
		itemNew3.setPublishTime(new Date());
		//����Ŀ4
		ItemNew itemNew4 = new ItemNew();
		itemNew4.setItemName("��Ʊ����ϵͳ");
		itemNew4.setMoney(4000);
		itemNew4.setContent("��Ʊ��Ʊ");
		itemNew4.setPublishTime(new Date());
		
		
		
		//����Ŀ1
		ItemOld itemOld = new ItemOld();
		itemOld.setItemName("ͼ��ݹ���ϵͳ");
		itemOld.setMoney(3500);
		itemOld.setContent("ͼ�����");
		itemOld.setPublishTime(new Date());
		//����Ŀ2
		ItemOld itemOld2 = new ItemOld();
		itemOld2.setItemName("������Դ����ϵͳ");
		itemOld2.setMoney(500);
		itemOld2.setContent("�˲Ź���");
		itemOld2.setPublishTime(new Date());
		//����Ŀ3
		ItemOld itemOld3 = new ItemOld();
		itemOld3.setItemName("��������ϵͳ");
		itemOld3.setMoney(1000);
		itemOld3.setContent("��������");
		itemOld3.setPublishTime(new Date());
		//����Ŀ4
		ItemOld itemOld4 = new ItemOld();
		itemOld4.setItemName("��ֳ������ϵͳ");
		itemOld4.setMoney(1000);
		itemOld4.setContent("��ֳ������Ѽ����");
		itemOld4.setPublishTime(new Date());
		
		
		
		//������1
		Publisher publisher = new Publisher();
		publisher.setUsername("����");
		publisher.setPassword("java1234");
		publisher.setTelephone("��119");
		publisher.setName("����");
		publisher.setEmail("123@qq.com");
		publisher.setBrief("�Һܰ���");
		//������2
		Publisher publisher2 = new Publisher();
		publisher2.setUsername("֣�ɹ�");
		publisher2.setPassword("helloworld23");
		publisher2.setTelephone("15709613570");
		publisher2.setName("֣�ɹ�");
		publisher2.setEmail("15709613570@qq.com");
		publisher2.setBrief("I'm very good !��");
		//������3
		Publisher publisher3 = new Publisher();
		publisher3.setUsername("����");
		publisher3.setPassword("HTML1234");
		publisher3.setTelephone("�Ǿ�119");
		publisher3.setName("����");
		publisher3.setEmail("hello@qq.com");
		publisher3.setBrief("�Һܰ���");
		//������4
		Publisher publisher4 = new Publisher();
		publisher4.setUsername("����");
		publisher4.setPassword("liufei");
		publisher4.setTelephone("15878348993");
		publisher4.setName("�ɻ�");
		publisher4.setEmail("feiji@qq.com");
		publisher4.setBrief("�һ�ɣ�");
		
		//������1
		Applicant applicant = new Applicant();
		applicant.setUsername("ë��");
		applicant.setPassword("maozedong123456");
		applicant.setTelephone("15978348093");
		applicant.setName("��֮");
		applicant.setEmail("maozedong@qq.com");
		applicant.setBrief("����ë�󶫣�");
		//������2
		Applicant applicant2 = new Applicant();
		applicant2.setUsername("����ʯ");
		applicant2.setPassword("jiangjieshi123456");
		applicant2.setTelephone("16978348993");
		applicant2.setName("��ʯ");
		applicant2.setEmail("jiangjiehsi@qq.com");
		applicant2.setBrief("���ǽ���ʯ��");
		//������3
		Applicant applicant3 = new Applicant();
		applicant3.setUsername("�ܶ���");
		applicant3.setPassword("zhouenlai123");
		applicant3.setTelephone("16908348993");
		applicant3.setName("����");
		applicant2.setEmail("zhouenlai@qq.com");
		applicant3.setBrief("�����ܶ�����");
		//������4
		Applicant applicant4 = new Applicant();
		applicant4.setUsername("�ֱ�");
		applicant4.setPassword("linbiao123456");
		applicant4.setTelephone("15278348093");
		applicant4.setName("�ֱ�");
		applicant4.setEmail("linbiao@qq.com");
		applicant4.setBrief("�����ֱ룡");
		
		//�����1
		Checkor checkor = new Checkor();
		checkor.setUsername("�����1");
		checkor.setPassword("123456nun");
		checkor.setUsertype("�����");
		checkor.setTelephone("15467876547");
		checkor.setName("���");
		checkor.setEmail("libai@qq.com");
		checkor.setBrief("����һ�����������ΰ��ʫ��");
		
		//��Ա1
		Menber menber = new Menber();
		menber.setName("�Ÿ�");
		menber.setTelephone("û�е绰");
		menber.setBrief("����һ��ΰ�����ʵ����һʫ��");
		menber.setAge(30);
		//��Ա2
		Menber menber2 = new Menber();
		menber2.setName("����Ԫ");
		menber2.setTelephone("û�е绰");
		menber2.setBrief("����һ��ΰ�����ʵ����ʫ��");
		menber2.setAge(40);
		
		//��Ա3
		Menber menber3 = new Menber();
		menber3.setName("�Ϻ�Ȼ");
		menber3.setTelephone("û�е绰");
		menber3.setBrief("����һ��ΰ�����԰���ʫ��");
		menber3.setAge(25);
		//��Ա4
		Menber menber4 = new Menber();
		menber4.setName("�׾���");
		menber4.setTelephone("û�е绰");
		menber4.setBrief("����һ��ΰ�����ʵ����ʫ��");
		menber4.setAge(50);
		
		//���ù�����ϵ
		
		//���÷�����������Ŀ�Ĺ�����ϵ
		publisher.setItemNew(itemNew);
		publisher2.setItemNew(itemNew2);
		publisher3.setItemNew(itemNew3);
		publisher4.setItemNew(itemNew4);
		
		itemNew.setPublisher(publisher);
		itemNew2.setPublisher(publisher2);
		itemNew3.setPublisher(publisher3);
		itemNew4.setPublisher(publisher4);
		
		//���÷����������Ŀ�Ĺ�����ϵ
		
		itemOld.setPublisher(publisher);
		itemOld2.setPublisher(publisher);
		
		publisher.getItemOlds().add(itemOld);
		publisher.getItemOlds().add(itemOld2);
		
		itemOld3.setPublisher(publisher2);
		itemOld4.setPublisher(publisher2);
		
		publisher2.getItemOlds().add(itemOld3);
		publisher2.getItemOlds().add(itemOld4);
		
		//����������������Ŀ�Ĺ�����ϵ
		applicant.setItemNew(itemNew);
		applicant2.setItemNew(itemNew);
		applicant3.setItemNew(itemNew3);
		applicant4.setItemNew(itemNew4);
		
		itemNew.getApplicants().add(applicant);
		itemNew.getApplicants().add(applicant2);
		itemNew3.getApplicants().add(applicant3);
		itemNew4.getApplicants().add(applicant4);
		
		//������������;���Ŀ�Ĺ�����ϵ
		itemOld.getApplicants().add(applicant);
		itemOld.getApplicants().add(applicant2);
		itemOld.getApplicants().add(applicant3);
		
		applicant.getItemOlds().add(itemOld);
		applicant.getItemOlds().add(itemOld2);
		applicant.getItemOlds().add(itemOld3);
		//�������������Ա�Ĺ�ϵ
		menber.setApplicant(applicant);
		menber2.setApplicant(applicant);
		
		applicant.getMenbers().add(menber);
		applicant.getMenbers().add(menber2);
		
		menber3.setApplicant(applicant3);
		menber4.setApplicant(applicant3);
		
		applicant3.getMenbers().add(menber3);
		applicant3.getMenbers().add(menber4);
		//����������������˵Ĺ�����ϵ
		checkor.getApplicants().add(applicant);
		checkor.getApplicants().add(applicant2);
		checkor.getApplicants().add(applicant3);
		
		applicant.setCheckor(checkor);
		applicant2.setCheckor(checkor);
		applicant3.setCheckor(checkor);
		//�������Ա
		session.save(admin);
		session.save(admin2);
		//����������
		session.save(applicant);
		session.save(applicant2);
		session.save(applicant3);
		session.save(applicant4);
		//���淢����
		session.save(publisher);
		session.save(publisher2);
		session.save(publisher3);
		session.save(publisher4);
		//���������
		session.save(checkor);
		//��������Ŀ
		session.save(itemNew);
		session.save(itemNew2);
		session.save(itemNew3);
		session.save(itemNew4);
		//�������Ŀ
		session.save(itemOld);
		session.save(itemOld2);
		session.save(itemOld3);
		session.save(itemOld4);
		//�������Ա
		session.save(menber);
		session.save(menber2);
		session.save(menber3);
		session.save(menber4);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
