package cn.edu.nun.action.publisher;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.service.PublisherService;

public class PublisherAddItemNew extends ActionSupport implements ModelDriven<ItemNew> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6989158946296995646L;
	private ItemNew itemNew;
	private PublisherService publisherService;
	
	public PublisherService getPublisherService() {
		return publisherService;
	}

	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

	@Override
	public ItemNew getModel() {
		// TODO Auto-generated method stub
		if(itemNew == null){
			itemNew = new ItemNew();
		}
		return itemNew;
	}

	public ItemNew getItemNew() {
		return itemNew;
	}

	public void setItemNew(ItemNew itemNew) {
		this.itemNew = itemNew;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = ServletActionContext.getRequest().getSession();
		int publisherId = (int) session.getAttribute("id");
		this.itemNew.setPublishTime(new Date());
		this.publisherService.publisherAddItemNew(publisherId, itemNew);
		System.out.println("添加新项目！");
		return super.execute();
	}
	
}
