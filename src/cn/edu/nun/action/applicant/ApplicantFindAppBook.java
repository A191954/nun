package cn.edu.nun.action.applicant;

import java.sql.Clob;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nun.entity.AppBook;
import cn.edu.nun.service.ApplicantService;

public class ApplicantFindAppBook extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6166961636090490039L;
	private ApplicantService applicantService;
	public ApplicantFindAppBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApplicantService getApplicantService() {
		return applicantService;
	}
	public void setApplicantService(ApplicantService applicantService) {
		this.applicantService = applicantService;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int appId = (int) ServletActionContext.getRequest().getSession().getAttribute("id");
		AppBook appBook = this.applicantService.findAppBook(appId);
		
		Clob clob = appBook.getTextBody();
		String textBody = clob.getSubString(1, (int)clob.length());
		ServletActionContext.getRequest().setAttribute("textBody", textBody);
		System.out.println("≤È’“≥…π¶£°");
		return SUCCESS;
	}
	
}
