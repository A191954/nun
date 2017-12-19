package cn.edu.nun.action.publisher;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.service.PublisherService;
import cn.edu.nun.service.impl.PublisherServiceImpl;

public class PublisherUpdateItemNew extends ActionSupport implements ModelDriven<ItemNew> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5749254332492134080L;
	private ItemNew itemNew;
	private PublisherService publisherService;
	
	
	public ItemNew getItemNew() {
		return itemNew;
	}


	public void setItemNew(ItemNew itemNew) {
		this.itemNew = itemNew;
	}


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


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("项目ID： " + this.itemNew.getId());
		System.out.println("项目名称： " + this.itemNew.getItemName());
		System.out.println("项目内容 ： " + this.itemNew.getContent());
		System.out.println("项目经费： " + this.itemNew.getMoney());
		this.publisherService.updateItemNew(this.itemNew);
		
		return SUCCESS;
	}

}
