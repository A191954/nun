package cn.edu.nun.service.impl;

import java.util.List;
import java.util.Map;

import cn.edu.nun.dao.ApplicantDao;
import cn.edu.nun.entity.AppBook;
import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Menber;
import cn.edu.nun.entity.Page;
import cn.edu.nun.service.ApplicantService;

public class ApplicantServiceImpl implements ApplicantService {

	private ApplicantDao applicantDao;

	public ApplicantDao getApplicantDao() {
		return applicantDao;
	}

	public void setApplicantDao(ApplicantDao applicantDao) {
		this.applicantDao = applicantDao;
	}

	@Override
	public void saveApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		this.applicantDao.saveApplicant(applicant);
	}

	@Override
	public Page<Applicant> getApplicantsByPage(Map<String, Object> queryFields, int currentPage) {
		// TODO Auto-generated method stub
		return this.applicantDao.getApplicantsByPage(queryFields, currentPage);
	}

	@Override
	public Applicant getApplicantById(int id) {
		// TODO Auto-generated method stub
		return this.applicantDao.getApplicantById(id);
	}

	@Override
	public void deleteApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		this.applicantDao.deleteApplicant(applicant);
	}

	@Override
	public void deleteAllApplicants(List<Applicant> applicants) {
		// TODO Auto-generated method stub
		this.applicantDao.deleteAllApplicants(applicants);
	}

	@Override
	public void updateApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		this.applicantDao.updateApplicant(applicant);
	}

	@Override
	public int checkLogin(Applicant applicantModel) {
		// TODO Auto-generated method stub
		return this.applicantDao.checkLogin(applicantModel);
	}

	@Override
	public Page<ItemOld> getItemOldsByApplicantId(int id, int currentPage) {
		// TODO Auto-generated method stub
		return this.applicantDao.getItemOldsByApplicantId(id, currentPage);
	}

	@Override
	public void DeclareItemNew(int appId, int itemNewId) {
		// TODO Auto-generated method stub
		this.applicantDao.DeclareItemNew(appId, itemNewId);
	}

	@Override
	public void addMenber(int appId, Menber menber) {
		// TODO Auto-generated method stub
		this.applicantDao.addMenber(appId, menber);
	}

	@Override
	public void deleteMenber(int appId, int menberId) {
		// TODO Auto-generated method stub
		this.applicantDao.deleteMenber(appId, menberId);
	}

	@Override
	public void updateMenber(Menber menber) {
		// TODO Auto-generated method stub
		this.applicantDao.updateMenber(menber);
	}

	@Override
	public ItemNew findItemNew(int appId) {
		// TODO Auto-generated method stub
		return this.applicantDao.findItemNew(appId);
	}

	@Override
	public void cancelItemNew(int appId, int itemNewId) {
		// TODO Auto-generated method stub
		this.applicantDao.cancelItemNew(appId, itemNewId);
	}

	@Override
	public void publishAppBook(int appId, AppBook appBook) {
		// TODO Auto-generated method stub
		this.applicantDao.publishAppBook(appId, appBook);
	}

	@Override
	public AppBook findAppBook(int appId) {
		// TODO Auto-generated method stub
		return this.applicantDao.findAppBook(appId);
	}

	

	
	
}
