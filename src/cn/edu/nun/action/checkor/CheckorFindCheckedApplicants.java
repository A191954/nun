package cn.edu.nun.action.checkor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.Page;
import cn.edu.nun.service.CheckorService;

public class CheckorFindCheckedApplicants extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9149778459507266824L;
	private CheckorService checkorService;
	private int currentPage = 1;

	public CheckorService getCheckorService() {
		return checkorService;
	}

	public void setCheckorService(CheckorService checkorService) {
		this.checkorService = checkorService;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int checkorId = (int) ServletActionContext.getRequest().getSession().getAttribute("id");
		Page<Applicant> page = this.checkorService.findCheckedApplicantByCheckor(checkorId, currentPage);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("page", page);
		return SUCCESS;
	}


	
}
