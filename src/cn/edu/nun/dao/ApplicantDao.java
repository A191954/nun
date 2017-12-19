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
	void saveApplicant(Applicant applicant); //���浥�� Applicant
	Page<Applicant> getApplicantsByPage(Map<String, Object> queryFields, int currentPage); //���� ��ѯ�ֶλ�ȡ Applicant
	Applicant getApplicantById(int id);  //��ȡָ����  Applicant
	void deleteApplicant(Applicant applicant); //ɾ������ Applicant
	void deleteAllApplicants(List<Applicant> applicants); //ɾ�����е�Applicant
	void updateApplicant(Applicant applicant); //���µ��� Applicant
	//��֤�����˵�¼
	int checkLogin(Applicant applicantModel); 
	//��Ŀ�����������ķ���
	Page<ItemOld> getItemOldsByApplicantId(int id, int currentPage);
	//��������Ŀ
	void DeclareItemNew(int appId, int itemNewId);
	//������Ա
	void addMenber(int appId, Menber menber);
	//ɾ�����Ա
	void deleteMenber(int appId, int menberId);
	//�޸����Ա
	void updateMenber(Menber menber);
	//��������Ŀ
	ItemNew findItemNew(int appId);
	//ȡ���걨����Ŀ
	void cancelItemNew(int appId, int itemNewId);
	//�����˷���������
	void publishAppBook(int appId, AppBook appBook);
	//�����˲鿴������
	AppBook findAppBook(int appId);
}
