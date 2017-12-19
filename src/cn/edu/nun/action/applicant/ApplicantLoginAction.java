package cn.edu.nun.action.applicant;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.nun.entity.Applicant;
import cn.edu.nun.service.ApplicantService;

public class ApplicantLoginAction extends ActionSupport implements ModelDriven<Applicant> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6285788617332461010L;
	private Applicant applicantModel;
	private ApplicantService applicantService;
	
	public ApplicantService getApplicantService() {
		return applicantService;
	}

	public void setApplicantService(ApplicantService applicantService) {
		this.applicantService = applicantService;
	}

	public Applicant getApplicantModel() {
		return applicantModel;
	}

	public void setApplicantModel(Applicant applicantModel) {
		this.applicantModel = applicantModel;
	}

	@Override
	public Applicant getModel() {
		// TODO Auto-generated method stub
		if(applicantModel == null){
			applicantModel = new Applicant();
		}
		return applicantModel;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(this.applicantModel.getUsername().equals("") || this.applicantModel.getPassword().equals("")){
			addFieldError("username", "用户名或密码不能为空！");
		}
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String backStr = "input";
		this.applicantModel.setUsername(this.applicantModel.getUsername().trim());
		this.applicantModel.setPassword(this.applicantModel.getPassword().trim());
		int id = this.applicantService.checkLogin(applicantModel);
		if(id >= 0){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("username", this.applicantModel.getUsername());
			session.setAttribute("id", id);
			session.setAttribute("usertype", this.applicantModel.getUsertype());
			backStr = "success";
		}
		System.out.println(this.applicantModel.getUsername() + "  " + this.applicantModel.getPassword());
		System.out.println(id);
		return backStr;
	}

	
	
}
