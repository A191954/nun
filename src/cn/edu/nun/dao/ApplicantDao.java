package cn.edu.nun.dao;

import java.util.List;
import java.util.Map;

import cn.edu.nun.entity.AppBook;
import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Menber;
import cn.edu.nun.entity.Page;

public interface ApplicantDao {
	void saveApplicant(Applicant applicant); //保存单个 Applicant
	Page<Applicant> getApplicantsByPage(Map<String, Object> queryFields, int currentPage); //根据 查询字段获取 Applicant
	Applicant getApplicantById(int id);  //获取指定的  Applicant
	void deleteApplicant(Applicant applicant); //删除单个 Applicant
	void deleteAllApplicants(List<Applicant> applicants); //删除所有的Applicant
	void updateApplicant(Applicant applicant); //更新单个 Applicant
	//验证申请人登录
	int checkLogin(Applicant applicantModel); 
	//项目进行中新增的方法
	Page<ItemOld> getItemOldsByApplicantId(int id, int currentPage);
	//申请新项目
	void DeclareItemNew(int appId, int itemNewId);
	//添加组成员
	void addMenber(int appId, Menber menber);
	//删除组成员
	void deleteMenber(int appId, int menberId);
	//修改组成员
	void updateMenber(Menber menber);
	//查找新项目
	ItemNew findItemNew(int appId);
	//取消申报新项目
	void cancelItemNew(int appId, int itemNewId);
	//申请人发布申请书
	void publishAppBook(int appId, AppBook appBook);
	//申请人查看申请书
	AppBook findAppBook(int appId);
}
