package cn.edu.nun.service.impl;

import java.util.List;
import java.util.Map;

import cn.edu.nun.dao.CheckorDao;
import cn.edu.nun.entity.AppBook;
import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.Checkor;
import cn.edu.nun.entity.Page;
import cn.edu.nun.service.CheckorService;

public class CheckorServiceImpl implements CheckorService {
	private CheckorDao checkorDao;
	
	public CheckorDao getCheckorDao() {
		return checkorDao;
	}

	public void setCheckorDao(CheckorDao checkorDao) {
		this.checkorDao = checkorDao;
	}

	@Override
	public void saveCheckor(Checkor checkor) {
		// TODO Auto-generated method stub
		this.checkorDao.saveCheckor(checkor);
	}

	@Override
	public Page<Checkor> getCheckorsByPage(Map<String, Object> queryFields, int currentPage) {
		// TODO Auto-generated method stub
		return this.checkorDao.getCheckorsByPage(queryFields, currentPage);
	}

	@Override
	public Checkor getCheckorById(int id) {
		// TODO Auto-generated method stub
		return this.checkorDao.getCheckorById(id);
	}

	@Override
	public void deleteCheckor(Checkor checkor) {
		// TODO Auto-generated method stub
		this.checkorDao.deleteCheckor(checkor);
	}

	@Override
	public void deleteAllCheckors(List<Checkor> checkors) {
		// TODO Auto-generated method stub
		this.checkorDao.deleteAllCheckors(checkors);
	}

	@Override
	public void updateCheckor(Checkor checkor) {
		// TODO Auto-generated method stub
		this.checkorDao.updateCheckor(checkor);
	}

	@Override
	public int checkLogin(Checkor checkorModel) {
		// TODO Auto-generated method stub
		return this.checkorDao.checkLogin(checkorModel);
	}

	@Override
	public Page<Applicant> findPublishItemNewApplicantsByPage(int currentPage) {
		// TODO Auto-generated method stub
		return this.checkorDao.findPublishItemNewApplicantsByPage(currentPage);
	}

	@Override
	public void checkApplicantItemNew(int checkorId, int appId, String checkedState, String noPassReason) {
		// TODO Auto-generated method stub
		this.checkorDao.checkApplicantItemNew(checkorId, appId, checkedState, noPassReason);
	}

	@Override
	public Page<Applicant> findCheckedApplicantByCheckor(int checkorId, int currentPage) {
		// TODO Auto-generated method stub
		return this.checkorDao.findCheckedApplicantByCheckor(checkorId, currentPage);
	}

	@Override
	public AppBook findAppBook(int appId) {
		// TODO Auto-generated method stub
		return this.checkorDao.findAppBook(appId);
	}
	

}
