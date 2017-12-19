package cn.edu.nun.service;

import java.util.List;
import java.util.Map;

import cn.edu.nun.entity.Admin;
import cn.edu.nun.entity.Page;

public interface AdminService {
	void saveAdmin(Admin admin); //����Admin
	Page<Admin> getAdminsByPage(Map<String, Object> queryFields, int currentPage); //ͨ����ѯ������ȡ ����������Admin
	Admin getAdminById(int id); //��ȡָ����Admin
	void deleteAdmin(Admin admin); //ɾ������Admin
	void deleteAllAdmins(List<Admin> admins); //ɾ�����е� Admin
	void updateAdmin(Admin admin); //���µ��� Admin
	//��¼����Ա��¼��֤
	int checkLogin(Admin adminModel); 
}
