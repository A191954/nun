package cn.edu.nun.service.impl;

import java.util.List;
import java.util.Map;

import cn.edu.nun.dao.ItemOldDao;
import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Page;
import cn.edu.nun.service.ItemOldService;

public class ItemOldServiceImpl implements ItemOldService {
	
	private ItemOldDao itemOldDao;
	
	

	public ItemOldDao getItemOldDao() {
		return itemOldDao;
	}

	public void setItemOldDao(ItemOldDao itemOldDao) {
		this.itemOldDao = itemOldDao;
	}

	@Override
	public void saveItemOld(ItemOld itemOld) {
		// TODO Auto-generated method stub
		this.itemOldDao.saveItemOld(itemOld);
	}

	@Override
	public Page<ItemOld> getItemOldsByPage(Map<String, Object> queryFields, int currentPage) {
		// TODO Auto-generated method stub
		return this.itemOldDao.getItemOldsByPage(queryFields, currentPage);
	}

	@Override
	public ItemOld getItemOldById(int id) {
		// TODO Auto-generated method stub
		return this.itemOldDao.getItemOldById(id);
	}

	@Override
	public void deleteItemOld(ItemOld itemOld) {
		// TODO Auto-generated method stub
		this.itemOldDao.deleteItemOld(itemOld);
	}

	@Override
	public void deleteAllItemOlds(List<ItemOld> itemOlds) {
		// TODO Auto-generated method stub
		this.deleteAllItemOlds(itemOlds);
	}

	@Override
	public void updateItemOld(ItemOld itemOld) {
		// TODO Auto-generated method stub
		this.itemOldDao.updateItemOld(itemOld);
	}
	
	

}
