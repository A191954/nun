package cn.edu.nun.action.applicant;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.engine.jdbc.ClobProxy;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.nun.entity.AppBook;
import cn.edu.nun.service.ApplicantService;

public class ApplicantPublishAppBook extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4987022224105263783L;
	private ApplicantService applicantService;
	private String textBody;

	
	
	public ApplicantPublishAppBook() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ApplicantService getApplicantService() {
		return applicantService;
	}


	public void setApplicantService(ApplicantService applicantService) {
		this.applicantService = applicantService;
	}


	public String getTextBody() {
		return textBody;
	}


	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("正在发布ing！");
		HttpSession  session = ServletActionContext.getRequest().getSession();
		int appId = (int) session.getAttribute("id");
		System.out.println("textbody = " + this.textBody);
		
		AppBook appBook = new AppBook();
		appBook.setTextBody(ClobProxy.generateProxy(this.textBody));
		
		this.applicantService.publishAppBook(appId, appBook);
		System.out.println("发布成功！");
		
		return SUCCESS;
		
	}


}
