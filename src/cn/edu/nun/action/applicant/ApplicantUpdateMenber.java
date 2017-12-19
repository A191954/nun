package cn.edu.nun.action.applicant;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.nun.entity.Menber;
import cn.edu.nun.service.ApplicantService;

public class ApplicantUpdateMenber extends ActionSupport implements ModelDriven<Menber> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3722348948389264933L;
	private Menber menber;
	private ApplicantService applicantService;
	private String updateMenberFlag;
	
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


	public Menber getMenber() {
		return menber;
	}


	public void setMenber(Menber menber) {
		this.menber = menber;
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
		System.out.println(this.menber.toString());
		this.applicantService.updateMenber(menber);
		this.updateMenberFlag = "updateSuccess";
		ServletActionContext.getRequest().getSession().setAttribute("updateMenberFlag", this.updateMenberFlag);
		System.out.println("ÕýÔÚÐÞ¸Ä£¡");
		return SUCCESS;
	}

	

}
