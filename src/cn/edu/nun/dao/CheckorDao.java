package cn.edu.nun.dao;

import java.util.List;
import java.util.Map;

import cn.edu.nun.entity.AppBook;
import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.Checkor;
import cn.edu.nun.entity.Page;

public interface CheckorDao {
	void saveCheckor(Checkor checkor);  //保存单个Checkor
	Page<Checkor> getCheckorsByPage(Map<String, Object> queryFields, int currentPage); //根据查询字段 获取Checkor
	Checkor getCheckorById(int id); //根据id获取Checkor
	void deleteCheckor(Checkor checkor); //删除单个Checkor
	void deleteAllCheckors(List<Checkor> checkors); //删除所有的Checkor
	void updateCheckor(Checkor checkor); //更新单个Checkor
	//验证审核人登录
	int checkLogin(Checkor checkorModel);
	//查找所有已经申请了新项目的项目申请人
	Page<Applicant> findPublishItemNewApplicantsByPage(int currentPage);
	//审核申请了新项目的申请人
	void checkApplicantItemNew(int checkorId, int appId, String checkedState, String noPassReason);
	//查找本人审核过的申请人
	Page<Applicant> findCheckedApplicantByCheckor(int checkorId, int currentPage);
	//查看申请人的申请书
	AppBook findAppBook(int appId);
}
