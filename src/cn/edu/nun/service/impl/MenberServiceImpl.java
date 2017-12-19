package cn.edu.nun.service.impl;

import java.util.List;
import java.util.Map;

import cn.edu.nun.dao.MenberDao;
import cn.edu.nun.entity.Menber;
import cn.edu.nun.entity.Page;
import cn.edu.nun.service.MenberService;

public class MenberServiceImpl implements MenberService {

	private MenberDao menberDao;
	
	public MenberDao getMenberDao() {
		return menberDao;
	}

	public void setMenberDao(MenberDao menberDao) {
		this.menberDao = menberDao;
	}

	@Override
	public void saveMenber(Menber menber) {
		// TODO Auto-generated method stub
		this.getMenberDao().saveMenber(menber);
	}

	@Override
	public Page<Menber> getMenbersByPage(Map<String, Object> queryFields, int currentPage) {
		// TODO Auto-generated method stub
		return this.menberDao.getMenbersByPage(queryFields, currentPage);
	}

	@Override
	public Menber getMenberById(int id) {
		// TODO Auto-generated method stub
		return this.menberDao.getMenberById(id);
	}

	@Override
	public void deleteMenber(Menber menber) {
		// TODO Auto-generated method stub
		this.menberDao.deleteMenber(menber);
	}

	@Override
	public void deleteAllMenbers(List<Menber> menbers) {
		// TODO Auto-generated method stub
		this.menberDao.deleteAllMenbers(menbers);
	}

	@Override
	public void updateMenber(Menber menber) {
		// TODO Auto-generated method stub
		this.menberDao.updateMenber(menber);
	}
	
	
}
