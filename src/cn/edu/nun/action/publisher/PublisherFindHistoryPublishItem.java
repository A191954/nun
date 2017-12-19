package cn.edu.nun.action.publisher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Page;
import cn.edu.nun.service.PublisherService;

public class PublisherFindHistoryPublishItem extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6717666660232219301L;
	private PublisherService publisherService;
	private int currentPage = 1;
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public PublisherService getPublisherService() {
		return publisherService;
	}

	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = ServletActionContext.getRequest().getSession();
		int publisherId = (int) session.getAttribute("id");
		ItemNew itemNew = this.publisherService.findItemNew(publisherId);
		Page<ItemOld> page = this.publisherService.findItemOld(publisherId, this.currentPage);
		List<ItemOld> itemOldList = page.getDatalist();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("page", page);
		request.setAttribute("itemOldList", itemOldList);
		if(itemNew != null){
			request.setAttribute("itemNew", itemNew);
		}
		return SUCCESS;
	}
	
}
