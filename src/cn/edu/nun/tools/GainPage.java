package cn.edu.nun.tools;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import cn.edu.nun.entity.Admin;
import cn.edu.nun.entity.ItemOld;
import cn.edu.nun.entity.Page;

public class GainPage {
	
	public Page getPage(Map<String, Object> listQueryFields, int currentPage, String className, Session session){
		Page page = null;
		try{
		StringBuilder listQueryHql = new StringBuilder("from " + Class.forName(className).getSimpleName() + " where 1 = 1");
		StringBuilder countHql = new StringBuilder("select count(*) from " + Class.forName(className).getSimpleName() + " where 1 = 1");
		//ƴ��list�� count��ѯ���
		if(listQueryFields != null && !listQueryFields.isEmpty()){
			for(Map.Entry<String, Object> param : listQueryFields.entrySet()){
				String key = param.getKey();
				listQueryHql.append(" and " + key + " = :" + key);
				countHql.append(" and " + key + " = :" + key);
			}
		}
		//�õ�Query����
		Query queryList = session.createQuery(listQueryHql.toString(), Class.forName(className));
		Query queryCount = session.createQuery(countHql.toString());
		//���ò�ѯ����
		if(listQueryFields != null && !listQueryFields.isEmpty()){
			QueryParamsSet.setQueryParams(queryList, listQueryFields);
			QueryParamsSet.setQueryParams(queryCount, listQueryFields);
		}
		//��ѯ������
		int querySize = Constant.pageSize;
		//��ѯ����
		int queryIndex = (currentPage-1) * querySize;
		//��ѯ���������ݼ�
		@SuppressWarnings("unchecked")
		List<?> queryDataList = queryList.setFirstResult(queryIndex)//
										.setMaxResults(querySize) //
										.getResultList();
		//�ܼ�¼��
		int queryTotalRecords = ((Number)queryCount.getResultList().get(0)).intValue();
		//����Page�� ����ʼ��
		page = new Page<>(queryTotalRecords, querySize, currentPage, queryDataList, Constant.startPage, Constant.endPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return page;
	}
}
