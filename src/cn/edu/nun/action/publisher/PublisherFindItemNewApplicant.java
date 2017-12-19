package cn.edu.nun.action.publisher;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.Page;
import cn.edu.nun.service.PublisherService;

public class PublisherFindItemNewApplicant extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1490659658866076846L;
	private PublisherService publisherService;
	private int itemNewId = -1;
	public int getItemNewId() {
		return itemNewId;
	}
	public void setItemNewId(int itemNewId) {
		this.itemNewId = itemNewId;
	}
	private int currentPage = 1;
	public PublisherService getPublisherService() {
		return publisherService;
	}
	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String backStr = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println("itemNewId is : " + this.itemNewId);
		if(this.itemNewId >= 0){
			System.out.println("itemNewId: " + this.itemNewId);
			Page<Applicant> page = this.publisherService.findItemNewApplicant(this.itemNewId, currentPage);
			request.setAttribute("page", page);
			if(page.getDatalist().size() != 0){
				backStr =  SUCCESS;
				request.setAttribute("backStr", backStr);
			}
			else{
				backStr = INPUT;
				request.setAttribute("backStr", backStr);
			}
		}
		else{
			backStr = NONE;
			request.setAttribute("backStr", backStr);
		}
		return backStr;
	}
}
