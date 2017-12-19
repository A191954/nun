package cn.edu.nun.action.publisher;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import cn.edu.nun.service.PublisherService;

public class PublisherLoginOutAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6068623705571778772L;
	
	@Override
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("username");
		session.removeAttribute("id");
		return INPUT;
	}

}
