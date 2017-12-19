package cn.edu.nun.service;

import java.util.List;
import java.util.Map;

import cn.edu.nun.entity.Menber;
import cn.edu.nun.entity.Page;

public interface MenberService {
	void saveMenber(Menber menber); //���浥��Menber
	Page<Menber> getMenbersByPage(Map<String, Object> queryFields, int currentPage); //���ݲ�ѯ�ֶλ�ȡmenber
	Menber getMenberById(int id); //����id��ȡ Menber
	void deleteMenber(Menber menber); //ɾ������Menber
	void deleteAllMenbers(List<Menber> menbers); //ɾ�����е�Menber
	void updateMenber(Menber menber); //���µ���Menber
}
