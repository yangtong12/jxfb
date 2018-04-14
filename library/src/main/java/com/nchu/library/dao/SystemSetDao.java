package com.nchu.library.dao;

import java.util.List;

import com.nchu.library.entity.SystemSet;

public interface SystemSetDao {
	/**
	 * 查询系统设置
	 * @return
	 */
	List<SystemSet> querySystemSet();
	
	/**
	 * 修改系统设置
	 */
	int modifySystemSet(SystemSet systemSet);
	/**
	 * 统计系数量
	 */
	int querySystemCount(SystemSet systemSet);

}
