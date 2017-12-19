package cn.edu.nun.action.checkor;

import java.sql.Clob;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nun.entity.AppBook;
import cn.edu.nun.service.CheckorService;

public class CheckorAppBook extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6902974664533396660L;
	private CheckorService checkorService;
	private int id;
	public CheckorService getCheckorService() {
		return checkorService;
	}

	public void setCheckorService(CheckorService checkorService) {
		this.checkorService = checkorService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CheckorAppBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		AppBook appBook = this.checkorService.findAppBook(this.id);
		Clob clob = appBook.getTextBody();
		String textBody =  clob.getSubString(1, (int)clob.length());
		ServletActionContext.getRequest().setAttribute("textBody", textBody);
		return SUCCESS;
	}
	
}
