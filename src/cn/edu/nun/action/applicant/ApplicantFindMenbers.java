package cn.edu.nun.action.applicant;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nun.entity.Menber;
import cn.edu.nun.service.ApplicantService;

public class ApplicantFindMenbers extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7648803915013670022L;
	private ApplicantService applicantService;
	private String deleteMenberFlag;
	private String addMenberFlag;
	private String updateMenberFlag;
	public String getDeleteMenberFlag() {
		return deleteMenberFlag;
	}

	public void setDeleteMenberFlag(String deleteMenberFlag) {
		this.deleteMenberFlag = deleteMenberFlag;
	}

	public String getAddMenberFlag() {
		return addMenberFlag;
	}

	public void setAddMenberFlag(String addMenberFlag) {
		this.addMenberFlag = addMenberFlag;
	}

	public String getUpdateMenberFlag() {
		return updateMenberFlag;
	}

	public void setUpdateMenberFlag(String updateMenberFlag) {
		this.updateMenberFlag = updateMenberFlag;
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
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int appId = (int) session.getAttribute("id");
		System.out.println("…Í«Î»Àµƒid: " + appId);
		//flag
		if(session.getAttribute("deleteMenberFlag") != null){
			this.deleteMenberFlag = (String) session.getAttribute("deleteMenberFlag");
			request.setAttribute("deleteMenberFlag", this.deleteMenberFlag);
			session.removeAttribute("deleteMenberFlag");
		}
		if(session.getAttribute("addMenberFlag") != null){
			this.addMenberFlag = (String) session.getAttribute("addMenberFlag");
			request.setAttribute("addMenberFlag", this.addMenberFlag);
			session.removeAttribute("addMenberFlag");
		}
		if(session.getAttribute("updateMenberFlag") != null){
			this.updateMenberFlag = (String) session.getAttribute("updateMenberFlag");
			request.setAttribute("updateMenberFlag", this.updateMenberFlag);
			session.removeAttribute("updateMenberFlag");
		}

		Set<Menber> menberList = this.applicantService.getApplicantById(appId).getMenbers();
		request.setAttribute("menberList", menberList);
		
		return SUCCESS;
	}

}
