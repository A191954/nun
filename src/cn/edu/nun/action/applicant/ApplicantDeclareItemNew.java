package cn.edu.nun.action.applicant;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.service.ApplicantService;

public class ApplicantDeclareItemNew extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 890469471098684885L;
	private int itemNewId;
	private ApplicantService applicantService;
	private ItemNew itemNew;
	
	private String declareItemNewFlag;
	public String getDeclareItemNewFlag() {
		return declareItemNewFlag;
	}
	public void setDeclareItemNewFlag(String declareItemNewFlag) {
		this.declareItemNewFlag = declareItemNewFlag;
	}
	public ItemNew getItemNew() {
		return itemNew;
	}
	public void setItemNew(ItemNew itemNew) {
		this.itemNew = itemNew;
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
		HttpSession session = ServletActionContext.getRequest().getSession();
		int appId = (int) session.getAttribute("id");
		Applicant applicant = this.applicantService.getApplicantById(appId);
		
		//�ж��û��Ƿ�����������Ŀ
		if(applicant.getItemNew() == null){
			//���������û����������Ŀ, ������������Ŀ
			this.applicantService.DeclareItemNew(appId, this.itemNewId);
			this.declareItemNewFlag = "declareSuccess";
			session.setAttribute("declareItemNewFlag", this.declareItemNewFlag);
			System.out.println("����Ŀ�ɹ����룡");
			return SUCCESS;
		}
		else{
			//chain ��ֵ
			itemNew = applicant.getItemNew();
			//�Ѿ�������, �򷵻�input
			return INPUT;
		}
		
	}
	
	
}
