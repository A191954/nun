package cn.edu.nun.service.impl;

import java.util.List;
import java.util.Map;

import cn.edu.nun.dao.PublisherDao;
import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Page;
import cn.edu.nun.entity.Publisher;
import cn.edu.nun.service.PublisherService;

public class PublisherServiceImpl implements PublisherService {
	
	private PublisherDao publisherDao;
	
	public PublisherDao getPublisherDao() {
		return publisherDao;
	}

	public void setPublisherDao(PublisherDao publisherDao) {
		this.publisherDao = publisherDao;
	}

	@Override
	public void savePublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		this.publisherDao.savePublisher(publisher);
	}

	@Override
	public Page<Publisher> getPublishersByPage(Map<String, Object> queryFields, int currentPage) {
		// TODO Auto-generated method stub
		return this.getPublishersByPage(queryFields, currentPage);
	}

	@Override
	public Publisher getPublisherById(int id) {
		// TODO Auto-generated method stub
		return this.publisherDao.getPublisherById(id);
	}

	@Override
	public void deletePublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		this.publisherDao.deletePublisher(publisher);
	}

	@Override
	public void deleteAllPublishers(List<Publisher> publishers) {
		// TODO Auto-generated method stub
		this.publisherDao.deleteAllPublishers(publishers);
	}

	@Override
	public void updatePublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		this.updatePublisher(publisher);
	}

	@Override
	public int checkLogin(Publisher publisherModel) {
		// TODO Auto-generated method stub
		return this.publisherDao.checkLogin(publisherModel);
	}

	@Override
	public Page<ItemOld> findItemOld(int publisherId, int currentPage) {
		// TODO Auto-generated method stub
		return this.publisherDao.findItemOld(publisherId, currentPage);
	}

	@Override
	public void publisherAddItemNew(int publisherId, ItemNew itemNew) {
		// TODO Auto-generated method stub
		this.publisherDao.publisherAddItemNew(publisherId, itemNew);
	}

	@Override
	public ItemNew findItemNew(int publisherId) {
		// TODO Auto-generated method stub
		return this.publisherDao.findItemNew(publisherId);
	}

	@Override
	public void updateItemNew(ItemNew itemNew) {
		// TODO Auto-generated method stub
		this.publisherDao.updateItemNew(itemNew);
	}

	@Override
	public Page<Applicant> findItemNewApplicant(int itemNewId, int currentPage) {
		// TODO Auto-generated method stub
		return this.publisherDao.findItemNewApplicant(itemNewId, currentPage);
	}

	
	
}
