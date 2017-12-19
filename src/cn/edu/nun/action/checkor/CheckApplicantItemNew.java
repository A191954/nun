package cn.edu.nun.action.checkor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.nun.entity.Applicant;
import cn.edu.nun.service.CheckorService;

public class CheckApplicantItemNew extends ActionSupport implements ModelDriven<Applicant>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6788369288343992232L;
	private CheckorService checkorService;
	private Applicant applicant;
	


	@Override
	public Applicant getModel() {
		// TODO Auto-generated method stub
		if(applicant == null){
			applicant = new Applicant();
		}
		return applicant;
	}


	public CheckorService getCheckorService() {
		return checkorService;
	}


	public void setCheckorService(CheckorService checkorService) {
		this.checkorService = checkorService;
	}


	public Applicant getApplicant() {
		return applicant;
	}


	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		int checkorId = (int) ServletActionContext.getRequest().getSession().getAttribute("id");
		System.out.println("appId = " + applicant.getId());
		System.out.println("审核状态： " + applicant.getCheckedState());
		System.out.println("没通过的理由： " + applicant.getNoPassReason());
		this.checkorService.checkApplicantItemNew(checkorId, this.applicant.getId(), this.applicant.getCheckedState(), this.applicant.getNoPassReason());
		return SUCCESS;
	}
}
