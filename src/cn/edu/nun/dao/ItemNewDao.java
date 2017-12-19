package cn.edu.nun.dao;

import java.util.List;
import java.util.Map;

import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.Page;

public interface ItemNewDao {
	void saveItemNew(ItemNew itemNew); //保存单个新发布的项目
	Page<ItemNew> getItemNewsByPage(Map<String, Object> queryFields, int currentPage); //根据查询字段获取ItemNews
	ItemNew getItemNewById(int id); //根据 id 获取ItemNew
	void deleteItemNew(ItemNew itemNew); //删除单个ItemNew
	void deleteAllItemNews(List<ItemNew> itemNews); //删除所有的ItemNews
	void updateItemNew(ItemNew itemNew); //更新单个ItemNew
}
