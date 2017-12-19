package cn.edu.nun.service;

import java.util.List;
import java.util.Map;

import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Page;

public interface ItemOldService {
	void saveItemOld(ItemOld itemOld); //保存单个新发布的项目
	Page<ItemOld> getItemOldsByPage(Map<String, Object> queryFields, int currentPage); //根据查询字段获取ItemOlds
	ItemOld getItemOldById(int id); //根据 id 获取ItemOld
	void deleteItemOld(ItemOld itemOld); //删除单个ItemOld
	void deleteAllItemOlds(List<ItemOld> itemOlds); //删除所有的ItemOlds
	void updateItemOld(ItemOld itemOld); //更新单个ItemOld
}
