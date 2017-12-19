package cn.edu.nun.service;

import java.util.List;
import java.util.Map;

import cn.edu.nun.entity.Menber;
import cn.edu.nun.entity.Page;

public interface MenberService {
	void saveMenber(Menber menber); //保存单个Menber
	Page<Menber> getMenbersByPage(Map<String, Object> queryFields, int currentPage); //根据查询字段获取menber
	Menber getMenberById(int id); //根据id获取 Menber
	void deleteMenber(Menber menber); //删除单个Menber
	void deleteAllMenbers(List<Menber> menbers); //删除所有的Menber
	void updateMenber(Menber menber); //更新单个Menber
}
