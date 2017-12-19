package cn.edu.nun.dao;

import java.util.List;
import java.util.Map;

import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Page;

public interface ItemOldDao {
	void saveItemOld(ItemOld itemOld); //���浥���·�������Ŀ
	Page<ItemOld> getItemOldsByPage(Map<String, Object> queryFields, int currentPage); //���ݲ�ѯ�ֶλ�ȡItemOlds
	ItemOld getItemOldById(int id); //���� id ��ȡItemOld
	void deleteItemOld(ItemOld itemOld); //ɾ������ItemOld
	void deleteAllItemOlds(List<ItemOld> itemOlds); //ɾ�����е�ItemOlds
	void updateItemOld(ItemOld itemOld); //���µ���ItemOld
}
