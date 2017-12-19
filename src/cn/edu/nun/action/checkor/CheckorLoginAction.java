package cn.edu.nun.action.checkor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.nun.entity.Checkor;
import cn.edu.nun.service.CheckorService;

public class CheckorLoginAction extends ActionSupport implements ModelDriven<Checkor> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4613530797509730800L;
	private Checkor checkor;
	private CheckorService checkorService;
	public CheckorService getCheckorService() {
		return checkorService;
	}
	public void setCheckorService(CheckorService checkorService) {
		this.checkorService = checkorService;
	}
	@Override
	public Checkor getModel() {
		// TODO Auto-generated method stub
		if(checkor == null){
			checkor = new Checkor();
		}
		return checkor;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String backStr = INPUT;
		this.checkor.setUsername(this.checkor.getUsername().trim());
		this.checkor.setPassword(this.checkor.getPassword().trim());
		int id = this.checkorService.checkLogin(checkor);
		if(id >= 0){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("username", this.checkor.getUsername());
			session.setAttribute("id", id);
			session.setAttribute("usertype", this.checkor.getUsertype());
			backStr = "success";
		}
		return backStr;
	}

}
