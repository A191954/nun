package cn.edu.nun.service;

import java.util.List;
import java.util.Map;

import cn.edu.nun.entity.Admin;
import cn.edu.nun.entity.Page;

public interface AdminService {
	void saveAdmin(Admin admin); //保存Admin
	Page<Admin> getAdminsByPage(Map<String, Object> queryFields, int currentPage); //通过查询参数获取 符合条件的Admin
	Admin getAdminById(int id); //获取指定的Admin
	void deleteAdmin(Admin admin); //删除单个Admin
	void deleteAllAdmins(List<Admin> admins); //删除所有的 Admin
	void updateAdmin(Admin admin); //更新单个 Admin
	//登录管理员登录验证
	int checkLogin(Admin adminModel); 
}
