package cn.edu.nun.service.impl;

import java.util.List;
import java.util.Map;

import cn.edu.nun.dao.ItemNewDao;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.Page;
import cn.edu.nun.service.ItemNewService;

public class ItemNewServiceImpl implements ItemNewService {

	private ItemNewDao itemNewDao;
	
	public ItemNewDao getItemNewDao() {
		return itemNewDao;
	}

	public void setItemNewDao(ItemNewDao itemNewDao) {
		this.itemNewDao = itemNewDao;
	}

	@Override
	public void saveItemNew(ItemNew itemNew) {
		// TODO Auto-generated method stub
		this.itemNewDao.saveItemNew(itemNew);
	}

	@Override
	public Page<ItemNew> getItemNewsByPage(Map<String, Object> queryFields, int currentPage) {
		// TODO Auto-generated method stub
		return this.itemNewDao.getItemNewsByPage(queryFields, currentPage);
	}

	@Override
	public ItemNew getItemNewById(int id) {
		// TODO Auto-generated method stub
		return this.itemNewDao.getItemNewById(id);
	}

	@Override
	public void deleteItemNew(ItemNew itemNew) {
		// TODO Auto-generated method stub
		this.itemNewDao.deleteItemNew(itemNew);
	}

	@Override
	public void deleteAllItemNews(List<ItemNew> itemNews) {
		// TODO Auto-generated method stub
		this.itemNewDao.deleteAllItemNews(itemNews);
	}

	@Override
	public void updateItemNew(ItemNew itemNew) {
		// TODO Auto-generated method stub
		this.itemNewDao.updateItemNew(itemNew);
	}
	
	
}
