package com.nchu.library.service;

import java.util.List;

import com.nchu.library.entity.SystemSet;

public interface SystemSetService {
	
	/**
	 * 查询系统设置
	 */
	List<SystemSet> querySystem();
	/**
	 * 修改系统设置
	 */
	int updateSystemSet(SystemSet systemSet);
	
	/**
	 * 统计系统数量
	 */
	int querySystemCount(SystemSet systemSet);

}
