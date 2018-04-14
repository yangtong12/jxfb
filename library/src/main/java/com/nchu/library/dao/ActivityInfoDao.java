package com.nchu.library.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nchu.library.entity.ActivityInfo;

public interface ActivityInfoDao {
	/**
	 * 查询活动
	 */
    ActivityInfo queryActivityInfo(long ActivityId);
    
	
	/**
	 * 修改预约状态
	 */
	int insertAppointmentInfo(ActivityInfo activityInfo);
	
   /**
    * 志愿者活动	
    */
	List<ActivityInfo> queryVolunterInfo(ActivityInfo activityInfo);
	
	/**
	 * 预约后要更新数据库
	 */
	int updateActivityInfo(ActivityInfo activityInfo);
	/**
	 * 后台查询
	 */
	List<ActivityInfo> querybyInfo(ActivityInfo activityInfo);
	/**
	 * 删除活动
	 */
	int deleteActivityInfo(long activityId);
	
	/**
	 * 计算活动
	 */
	int queryActivityCount(ActivityInfo activityInfo);
	

}
