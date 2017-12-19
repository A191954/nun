package cn.edu.nun.action.admin;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.nun.entity.Admin;

public class AdminGetPersonInfo extends ActionSupport implements ModelDriven<Admin> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6930052631530642166L;

	private Admin adminModel;
	
	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return adminModel;
	}

}
