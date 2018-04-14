package com.nchu.library.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nchu.library.dao.ActivityInfoDao;
import com.nchu.library.entity.ActivityInfo;
import com.nchu.library.service.ActivityInfoService;

@Service
public class ActivityInfoServiceImpl implements ActivityInfoService{
	@Autowired
	private ActivityInfoDao activityInfoDao;
	@Override
	public ActivityInfo getActivityInfo(long ActivityId) {
		// TODO Auto-generated method stub
		return activityInfoDao.queryActivityInfo(ActivityId);
	}
	@Override
	@Transactional
	public int addActivityInfo(ActivityInfo activityInfo) {
		// TODO Auto-generated method stub
		int effNum=0;
		try{
			effNum=activityInfoDao.insertAppointmentInfo(activityInfo);
			if(effNum<=0) {
				throw new RuntimeException("添加预约信息失败");
			}
		}catch(Exception e) {
			throw new RuntimeException("添加预约信息失败"+e.getMessage());
		}
		return effNum;
	}
	@Override
	public List<ActivityInfo> getVolunteerInfo(ActivityInfo activityInfo) {
		// TODO Auto-generated method stub
		
		return activityInfoDao.queryVolunterInfo(activityInfo);
	}
	@Override
	@Transactional
	public int leftcount(long activityid) {
		// TODO Auto-generated method stub
		ActivityInfo activityInfo=activityInfoDao.queryActivityInfo(activityid);
		if(activityInfo.getLeftorderNum()>0) {
			activityInfo.setLeftorderNum(activityInfo.getLeftorderNum()-1);
			int effNum=activityInfoDao.updateActivityInfo(activityInfo);
			if(effNum<=0) {
				throw new RuntimeException("预约失败!");
			}
			return effNum;
		}
		return 0;
	}
	@Override
	public List<ActivityInfo> queryManage(ActivityInfo activityInfo) {
		// TODO Auto-generated method stub
		return activityInfoDao.querybyInfo(activityInfo);
	}
	@Override
	@Transactional
	public int deleteActivity(long activityid) {
		// TODO Auto-generated method stub
		int effNum=activityInfoDao.deleteActivityInfo(activityid);
		return effNum;
	}
	@Override
	@Transactional
	public int updateActivity(ActivityInfo activityInfo) {
		// TODO Auto-generated method stub
		int effNum=0;
		try {
			effNum=activityInfoDao.updateActivityInfo(activityInfo);
			if(effNum<=0) {
				throw new RuntimeException("更新活动信息失败");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return effNum;
	}
	@Override
	public int queryActivityCount(ActivityInfo activityInfo) {
		// TODO Auto-generated method stub
		return activityInfoDao.queryActivityCount(activityInfo);
	}

}
