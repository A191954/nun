package cn.edu.nun.action.applicant;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.nun.entity.Menber;
import cn.edu.nun.service.ApplicantService;

public class ApplicantAddMenber extends ActionSupport implements ModelDriven<Menber> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8346115901985211127L;
	private Menber menber;
	private ApplicantService applicantService;
	private String addMenberFlag;
	
	public String getAddMenberFlag() {
		return addMenberFlag;
	}

	public void setAddMenberFlag(String addMenberFlag) {
		this.addMenberFlag = addMenberFlag;
	}

	public Menber getMenber() {
		return menber;
	}

	public void setMenber(Menber menber) {
		this.menber = menber;
	}

	public ApplicantService getApplicantService() {
		return applicantService;
	}

	public void setApplicantService(ApplicantService applicantService) {
		this.applicantService = applicantService;
	}

	@Override
	public Menber getModel() {
		// TODO Auto-generated method stub
		if(menber == null){
			menber = new Menber();
		}
		return menber;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = (HttpSession) ServletActionContext.getRequest() //
							.getSession();
		int appId = (int) session.getAttribute("id");
		this.applicantService.addMenber(appId, menber);
		this.addMenberFlag = "addSuccess";
		session.setAttribute("addMenberFlag", this.addMenberFlag);
		return SUCCESS;
	}

}
