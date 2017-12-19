package cn.edu.nun.action.applicant;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.Page;
import cn.edu.nun.service.ItemNewService;

public class ApplicantShowItemNew extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 890469471098684885L;
	private ItemNewService itemNewService;
	private int currentPage = 1;

	private ItemNew itemNew;
	
	public ItemNew getItemNew() {
		return itemNew;
	}

	public void setItemNew(ItemNew itemNew) {
		this.itemNew = itemNew;
	}

	public ItemNewService getItemNewService() {
		return itemNewService;
	}

	public void setItemNewService(ItemNewService itemNewService) {
		this.itemNewService = itemNewService;
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
		Map<String, Object> queryField = new HashMap<String, Object>();
		Page<ItemNew> page = itemNewService.getItemNewsByPage(queryField, this.currentPage);
		@SuppressWarnings("unchecked")
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("page", page);
		if(itemNew != null){
			System.out.println(itemNew.getItemName());
		}
		return SUCCESS;
	}

}
