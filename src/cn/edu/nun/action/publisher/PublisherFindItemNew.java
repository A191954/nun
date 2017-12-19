package cn.edu.nun.action.publisher;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.service.PublisherService;

public class PublisherFindItemNew extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PublisherService publisherService;
	public PublisherService getPublisherService() {
		return publisherService;
	}
	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		int publisherId = (int) ServletActionContext.getRequest().getSession().getAttribute("id");
		System.out.println("发布人的id: " + publisherId);
		ItemNew itemNew = this.publisherService.findItemNew(publisherId);
		List<ItemNew> itemNewList = new ArrayList<ItemNew>(0);
		
		if(itemNew != null){
			itemNewList.add(itemNew);
			System.out.println("新发布的项目名称是： " + itemNew.getItemName());
		}
		request.setAttribute("itemNewList", itemNewList);
		
		request.setAttribute("itemNew", itemNew);
		return SUCCESS;
	}
}
