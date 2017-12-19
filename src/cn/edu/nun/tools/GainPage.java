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
		//拼接list、 count查询语句
		if(listQueryFields != null && !listQueryFields.isEmpty()){
			for(Map.Entry<String, Object> param : listQueryFields.entrySet()){
				String key = param.getKey();
				listQueryHql.append(" and " + key + " = :" + key);
				countHql.append(" and " + key + " = :" + key);
			}
		}
		//得到Query对象
		Query queryList = session.createQuery(listQueryHql.toString(), Class.forName(className));
		Query queryCount = session.createQuery(countHql.toString());
		//设置查询参数
		if(listQueryFields != null && !listQueryFields.isEmpty()){
			QueryParamsSet.setQueryParams(queryList, listQueryFields);
			QueryParamsSet.setQueryParams(queryCount, listQueryFields);
		}
		//查询多少条
		int querySize = Constant.pageSize;
		//查询索引
		int queryIndex = (currentPage-1) * querySize;
		//查询出来的数据集
		@SuppressWarnings("unchecked")
		List<?> queryDataList = queryList.setFirstResult(queryIndex)//
										.setMaxResults(querySize) //
										.getResultList();
		//总记录数
		int queryTotalRecords = ((Number)queryCount.getResultList().get(0)).intValue();
		//创建Page， 并初始化
		page = new Page<>(queryTotalRecords, querySize, currentPage, queryDataList, Constant.startPage, Constant.endPage);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return page;
	}
}
