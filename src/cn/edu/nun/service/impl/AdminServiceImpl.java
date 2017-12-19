package cn.edu.nun.service.impl;

import java.util.List;
import java.util.Map;

import cn.edu.nun.dao.AdminDao;
import cn.edu.nun.entity.Admin;
import cn.edu.nun.entity.Page;
import cn.edu.nun.service.AdminService;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;
	

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.adminDao.saveAdmin(admin);
	}

	@Override
	public Page<Admin> getAdminsByPage(Map<String, Object> queryFields, int currentPage) {
		// TODO Auto-generated method stub
		return this.adminDao.getAdminsByPage(queryFields, currentPage);
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return this.adminDao.getAdminById(id);
	}

	@Override
	public void deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.adminDao.deleteAdmin(admin);
	}

	@Override
	public void deleteAllAdmins(List<Admin> admins) {
		// TODO Auto-generated method stub
		this.adminDao.deleteAllAdmins(admins);
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.adminDao.updateAdmin(admin);
	}

	@Override
	public int checkLogin(Admin adminModel) {
		// TODO Auto-generated method stub
		return this.adminDao.checkLogin(adminModel);
	}

	

}
