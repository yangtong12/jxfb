package com.nchu.library.service;

import java.util.List;

import com.nchu.library.entity.ActivityInfo;

public interface ActivityInfoService {
	
	/**
	 * 查询活动
	 */
	ActivityInfo getActivityInfo(long ActivityId);
	/**
	 * 用户预约后要添加数据
	 */
	int addActivityInfo(ActivityInfo activityInfo);
	
	/**
	 * 志愿者活动
	 */
	List<ActivityInfo> getVolunteerInfo(ActivityInfo activityInfo);
	/**
	 * 查询是否还有柜子
	 */
	int leftcount(long ActivityId);
	/**
	 * 后台查询
	 */
	List<ActivityInfo> queryManage(ActivityInfo activityInfo);
	/**
	 * 删除数据
	 */
	int deleteActivity(long activityid);
	/**
	 * 修改活动信息
	 */
	int updateActivity(ActivityInfo activityInfo);
	/**
	 * 查询活动数
	 */
	int queryActivityCount(ActivityInfo activityInfo);

}
