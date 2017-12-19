package cn.edu.nun.tools;

import java.util.Map;

import org.hibernate.query.Query;

public class QueryParamsSet {
	/**
	 * 设置查询的参数
	 * @param query
	 * @param paramMap
	 * @return
	 */
	
	public static Query setQueryParams(Query query, Map<String, Object> paramMap){
		if(paramMap != null && !paramMap.isEmpty()){
			for(Map.Entry<String, Object> param : paramMap.entrySet()){
				query.setParameter(param.getKey(), param.getValue());
			}
		}
		return query;
	}
}
