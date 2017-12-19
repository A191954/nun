package cn.edu.nun.action.applicant;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nun.service.ApplicantService;

public class ApplicantCancelItemNew extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1891026968448694973L;
	private ApplicantService applicantService;
	private int itemNewId;
	private String cancelItemNewFlag;
	public String getCancelItemNewFlag() {
		return cancelItemNewFlag;
	}

	public void setCancelItemNewFlag(String cancelItemNewFlag) {
		this.cancelItemNewFlag = cancelItemNewFlag;
	}

	public int getItemNewId() {
		return itemNewId;
	}

	public void setItemNewId(int itemNewId) {
		this.itemNewId = itemNewId;
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
		HttpSession session = (HttpSession) ServletActionContext.getRequest() //
				.getSession();
		int appId = (int) session.getAttribute("id");
		this.applicantService.cancelItemNew(appId, this.itemNewId);
		this.cancelItemNewFlag = "cancelSuccess";
		session.setAttribute("cancelItemNewFlag", this.cancelItemNewFlag);
		return SUCCESS;
	}

}
