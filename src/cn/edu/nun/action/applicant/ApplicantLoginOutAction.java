package cn.edu.nun.action.applicant;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.nun.entity.Applicant;

public class ApplicantLoginOutAction extends ActionSupport implements ModelDriven<Applicant> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1477930045596835181L;
	private Applicant applicant;
	
	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	@Override
	public Applicant getModel() {
		// TODO Auto-generated method stub
		if(applicant == null){
			applicant = new Applicant();
		}
		return applicant;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("username");
		return INPUT;
	}
	
}
