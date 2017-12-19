package cn.edu.nun.action.publisher;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.nun.entity.Publisher;
import cn.edu.nun.service.PublisherService;

public class PublisherLoginAction extends ActionSupport implements ModelDriven<Publisher> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6068623705571778772L;
	private Publisher publisher;
	private PublisherService publisherService;
	public PublisherService getPublisherService() {
		return publisherService;
	}

	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

	

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public Publisher getModel() {
		// TODO Auto-generated method stub
		if(publisher == null){
			publisher = new Publisher();
		}
		return publisher;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String backStr = INPUT;
		this.publisher.setUsername(this.publisher.getUsername().trim());
		this.publisher.setPassword(this.publisher.getPassword().trim());
		int id = this.publisherService.checkLogin(publisher);
		System.out.println("publisherid :  " + id);
		if(id >= 0){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("username", this.publisher.getUsername().trim());
			session.setAttribute("id", id);
			session.setAttribute("usertype", this.publisher.getUsertype());
			backStr = SUCCESS;
		}
		return backStr;
	}

}
