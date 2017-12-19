package cn.edu.nun.action.applicant;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nun.service.ApplicantService;

public class ApplicantDeleteMenber extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120805860303674901L;
	private ApplicantService applicantService;
	private int menberId;
	private String deleteMenberFlag;
	
	public String getDeleteMenberFlag() {
		return deleteMenberFlag;
	}

	public void setDeleteMenberFlag(String deleteMenberFlag) {
		this.deleteMenberFlag = deleteMenberFlag;
	}

	public ApplicantService getApplicantService() {
		return applicantService;
	}
	
	public void setApplicantService(ApplicantService applicantService) {
		this.applicantService = applicantService;
	}

	public int getMenberId() {
		return menberId;
	}
	
	public void setMenberId(int menberId) {
		this.menberId = menberId;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = ServletActionContext.getRequest().getSession();
		int appId = (int) session.getAttribute("id");
		System.out.println("appId : " + appId);
		System.out.println("≥…‘±Id : " + this.menberId);
		this.applicantService.deleteMenber(appId, this.menberId);
		this.deleteMenberFlag = "deleteSuccess";
		session.setAttribute("deleteMenberFlag", this.deleteMenberFlag);
		return SUCCESS;
	}

}
