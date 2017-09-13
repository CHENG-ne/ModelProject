package com.cheng.normal.api.mapper;

import java.util.List;

/**
 * @author cheng
 * @date 2017年8月17日  上午10:06:30
 */
public interface BaseMapper<T> {
	
	public int insert(T entity);
	   
    int insertSelective(T entity);

    T selectByPrimaryKey(String id);

    int deleteByPrimaryKey(String id);
    
    int updateByPrimaryKeySelective(T entity);

    int updateByPrimaryKey(T entity);
    
    List<T> selectAll();

}
