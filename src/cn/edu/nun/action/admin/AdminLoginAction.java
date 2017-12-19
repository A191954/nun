package cn.edu.nun.action.admin;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.nun.entity.Admin;
import cn.edu.nun.service.AdminService;

public class AdminLoginAction extends ActionSupport implements ModelDriven<Admin> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1495001118118373345L;
	private Admin adminModel;
	private AdminService adminService;
	private String errorMessage;
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Admin getAdminModel() {
		return adminModel;
	}

	public void setAdminModel(Admin adminModel) {
		this.adminModel = adminModel;
	}

	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		if(adminModel == null){
			adminModel = new Admin();
		}
		return adminModel;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(this.adminModel.getUsername().equals("") || this.adminModel.getPassword().equals("")){
			addFieldError("username", "用户名或密码不能为空！");
		}
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String backStr = "input";
		adminModel.setUsername(adminModel.getUsername().trim());
		adminModel.setPassword(adminModel.getPassword().trim());
		int id = this.adminService.checkLogin(adminModel);
		if(id >= 0){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("username", this.adminModel.getUsername());
			session.setAttribute("id", id);
			backStr = "success";
		}
		
		System.out.println(this.adminModel.getUsername() + "  " + this.adminModel.getPassword());
		System.out.println(id);
		return backStr;
	}

}
