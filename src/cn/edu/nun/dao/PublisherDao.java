package cn.edu.nun.dao;

import java.util.List;
import java.util.Map;

import cn.edu.nun.entity.Applicant;
import cn.edu.nun.entity.ItemNew;
import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Page;
import cn.edu.nun.entity.Publisher;

public interface PublisherDao {
	void savePublisher(Publisher publisher); //���浥�� Publisher
	Page<Publisher> getPublishersByPage(Map<String, Object> queryFields, int currentPage); //���ݲ�ѯ�ֶλ�ȡPublisher
	Publisher getPublisherById(int id); //����id��ȡ����Publisher
	void deletePublisher(Publisher publisher); //ɾ������Publisher
	void deleteAllPublishers(List<Publisher> publishers); //ɾ�����е�Publisher
	void updatePublisher(Publisher publisher); //���µ���publisher
	//��֤��¼
	int checkLogin(Publisher publisherModel);
	//������ʷ������Ŀ
	Page<ItemOld> findItemOld(int publisherId, int currentPage);
	//��������Ŀ
	void publisherAddItemNew(int publisherId, ItemNew itemNew);
	//�鿴�·�����Ŀ
	ItemNew findItemNew(int publisherId);
	//�޸�����Ŀ
	void updateItemNew(ItemNew itemNew);
	//�鿴����Ŀ�걨��
	Page<Applicant> findItemNewApplicant(int itemNewId, int currentPage);
}
