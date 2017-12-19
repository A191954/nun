package cn.edu.nun.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.nun.action.publisher.PublisherLoginAction;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.Page;
import cn.edu.nun.service.ItemNewService;
import cn.edu.nun.service.ItemOldService;
import cn.edu.nun.service.PublisherService;

public class TestItenService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		ItemOldService itemOldService = (ItemOldService) context.getBean("itemOldService");
//		
//		itemOldService.getItemOldsByPage(null, 1);
		
		PublisherLoginAction publisherLoginAction = (PublisherLoginAction) context.getBean("publisherLoginAction");
		System.out.println(publisherLoginAction);
	}

}
