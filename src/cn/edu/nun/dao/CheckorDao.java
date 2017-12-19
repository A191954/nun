package cn.edu.nun.dao;

import java.util.List;
import java.util.Map;

import cn.edu.nun.entity.AppBook;
import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.Checkor;
import cn.edu.nun.entity.Page;

public interface CheckorDao {
	void saveCheckor(Checkor checkor);  //���浥��Checkor
	Page<Checkor> getCheckorsByPage(Map<String, Object> queryFields, int currentPage); //���ݲ�ѯ�ֶ� ��ȡCheckor
	Checkor getCheckorById(int id); //����id��ȡCheckor
	void deleteCheckor(Checkor checkor); //ɾ������Checkor
	void deleteAllCheckors(List<Checkor> checkors); //ɾ�����е�Checkor
	void updateCheckor(Checkor checkor); //���µ���Checkor
	//��֤����˵�¼
	int checkLogin(Checkor checkorModel);
	//���������Ѿ�����������Ŀ����Ŀ������
	Page<Applicant> findPublishItemNewApplicantsByPage(int currentPage);
	//�������������Ŀ��������
	void checkApplicantItemNew(int checkorId, int appId, String checkedState, String noPassReason);
	//���ұ�����˹���������
	Page<Applicant> findCheckedApplicantByCheckor(int checkorId, int currentPage);
	//�鿴�����˵�������
	AppBook findAppBook(int appId);
}
