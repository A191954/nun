package cn.edu.nun.action.applicant;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Page;
import cn.edu.nun.service.ApplicantService;

public class ApplicantFindOldHistory extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2041838153253457978L;
	private ApplicantService applicantService;
	private int currentPage = 1;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public ApplicantService getApplicantService() {
		return applicantService;
	}
	public void setApplicantService(ApplicantService applicantService) {
		this.applicantService = applicantService;
	}
	
	/**
	 * ������������ʷ�걨��Ŀ
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = ServletActionContext.getRequest().getSession();
		int id = (int) session.getAttribute("id");
//		int currentPage = 1;
		//��ȡ��ʷ�걨��Ŀ
		Page<ItemOld> page = this.applicantService.getItemOldsByApplicantId(id, this.currentPage);
		List<ItemOld> itemOldList = page.getDatalist();
		int totalPages = page.getTotalPages();
		ActionContext context = ActionContext.getContext();
		Map<String, Object> request = (Map<String, Object>) context.get("request");
		request.put("itemOldList", itemOldList);
		request.put("page", page);
		System.out.println("jjjj" + page.getCurrentPage());
		System.out.println("ǰһҳ��" + page.getPrePage());
		System.out.println("��һҳ��" + page.getNextPage());
		return "success";
	}

}
