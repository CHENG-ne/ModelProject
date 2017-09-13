package com.cheng.normal.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cheng.normal.api.mapper.BaseMapper;
import com.cheng.normal.api.service.IBaseService;

/**
 * @author cheng
 * @param <T>
 * @date 2017年8月17日  上午9:52:12
 */
public class BaseServiceImpl<T> implements IBaseService<T>{
	
	@Autowired
	private BaseMapper<T> mapper;

	/* (non-Javadoc)
	 * @see com.normal.api.service.IBaseService#insertEntity(java.lang.Object)
	 */
	@Override
	public int insertEntity(T entity) throws Exception {
		try {
			return mapper.insertSelective(entity);
		} catch (Exception e) {
			throw new RuntimeException("插入数据异常:"+e.getMessage(),e);
		}
	}

	/* (non-Javadoc)
	 * @see com.normal.api.service.IBaseService#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		try {
			return mapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			throw new RuntimeException("删除数据异常:"+e.getMessage(),e);
		}
	}

	/* (non-Javadoc)
	 * @see com.normal.api.service.IBaseService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public T selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.normal.api.service.IBaseService#selectAll()
	 */
	@Override
	public List<T> selectAll() {
		return mapper.selectAll();
	}

	/* (non-Javadoc)
	 * @see com.normal.api.service.IBaseService#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(T entity) {
		try {
			return mapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new RuntimeException("更改数据异常:"+e.getMessage(),e);
		}
	}

}
