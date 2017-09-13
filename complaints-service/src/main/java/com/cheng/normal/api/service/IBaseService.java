package com.cheng.normal.api.service;

import java.util.List;

/**
 * @author cheng
 * @param <T> 泛型
 * @date 2017年8月17日  上午9:40:56
 */
public interface IBaseService<T> {

	int insertEntity(T entity) throws Exception;
	
	int deleteByPrimaryKey(String id);

    T selectByPrimaryKey(String id);
    
    List<T> selectAll();

    int updateByPrimaryKeySelective(T entity);

}
