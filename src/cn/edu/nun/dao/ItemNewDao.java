package cn.edu.nun.dao;

import java.util.List;
import java.util.Map;

import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.Page;

public interface ItemNewDao {
	void saveItemNew(ItemNew itemNew); //���浥���·�������Ŀ
	Page<ItemNew> getItemNewsByPage(Map<String, Object> queryFields, int currentPage); //���ݲ�ѯ�ֶλ�ȡItemNews
	ItemNew getItemNewById(int id); //���� id ��ȡItemNew
	void deleteItemNew(ItemNew itemNew); //ɾ������ItemNew
	void deleteAllItemNews(List<ItemNew> itemNews); //ɾ�����е�ItemNews
	void updateItemNew(ItemNew itemNew); //���µ���ItemNew
}
