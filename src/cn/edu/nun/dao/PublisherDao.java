package cn.edu.nun.dao;

import java.util.List;
import java.util.Map;

import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Page;
import cn.edu.nun.entity.Publisher;

public interface PublisherDao {
	void savePublisher(Publisher publisher); //保存单个 Publisher
	Page<Publisher> getPublishersByPage(Map<String, Object> queryFields, int currentPage); //根据查询字段获取Publisher
	Publisher getPublisherById(int id); //根据id获取单个Publisher
	void deletePublisher(Publisher publisher); //删除单个Publisher
	void deleteAllPublishers(List<Publisher> publishers); //删除所有的Publisher
	void updatePublisher(Publisher publisher); //更新单个publisher
	//验证登录
	int checkLogin(Publisher publisherModel);
	//查找历史发布项目
	Page<ItemOld> findItemOld(int publisherId, int currentPage);
	//发布新项目
	void publisherAddItemNew(int publisherId, ItemNew itemNew);
	//查看新发布项目
	ItemNew findItemNew(int publisherId);
	//修改新项目
	void updateItemNew(ItemNew itemNew);
	//查看新项目申报人
	Page<Applicant> findItemNewApplicant(int itemNewId, int currentPage);
}
