package cn.edu.nun.action.applicant;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.service.ApplicantService;

public class ApplicantFindItemNew extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7648803915013670022L;
	private ApplicantService ApplicantService;
	private String declareItemNewFlag;
	private String cancelItemNewFlag;
	
	
	public String getCancelItemNewFlag() {
		return cancelItemNewFlag;
	}

	public void setCancelItemNewFlag(String cancelItemNewFlag) {
		this.cancelItemNewFlag = cancelItemNewFlag;
	}

	public ApplicantService getApplicantService() {
		return ApplicantService;
	}

	public String getDeclareItemNewFlag() {
		return declareItemNewFlag;
	}

	public void setDeclareItemNewFlag(String declareItemNewFlag) {
		this.declareItemNewFlag = declareItemNewFlag;
	}

	public void setApplicantService(ApplicantService applicantService) {
		ApplicantService = applicantService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = ServletActionContext.getRequest().getSession();
		int appId = (int) session.getAttribute("id");
		HttpServletRequest request = ServletActionContext.getRequest();
		Applicant applicant = this.ApplicantService.getApplicantById(appId);
		List<Applicant> applicantList = new ArrayList<Applicant>(0);
		if(applicant.getItemNew() != null){
			applicantList.add(applicant);
			if(session.getAttribute("declareItemNewFlag") != null){
				this.declareItemNewFlag = (String) session.getAttribute("declareItemNewFlag");
				request.setAttribute("declareItemNewFlag", this.declareItemNewFlag);
				System.out.println("this.declareItemNewFlag = " + this.declareItemNewFlag);
				session.removeAttribute("declareItemNewFlag");
			}
			
			
		}
		
		if(session.getAttribute("cancelItemNewFlag") != null){
			this.cancelItemNewFlag = (String) session.getAttribute("cancelItemNewFlag");
			request.setAttribute("cancelItemNewFlag", this.cancelItemNewFlag);
			System.out.println("this.cancelItemNewFlag = " + this.cancelItemNewFlag);
			session.removeAttribute("cancelItemNewFlag");
		}
		request.setAttribute("applicantList", applicantList);
		return SUCCESS;
	}
}
