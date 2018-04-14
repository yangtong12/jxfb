package com.nchu.library;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nchu.library.dao.ActivityInfoDao;
import com.nchu.library.dao.OrderInfoDao;
import com.nchu.library.dao.SystemSetDao;
import com.nchu.library.entity.ActivityInfo;
import com.nchu.library.entity.OrderInfo;
import com.nchu.library.entity.SystemSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityInfoDaoTest {
	@Autowired
	private ActivityInfoDao activityInfoDao;
	@Autowired
	private OrderInfoDao orderInfoDao;
	@Autowired
	private SystemSetDao systemsetDao;
/*	@Test
	public void testActivityDao() {
		//ActivityInfo activityInfo=activityInfoDao.queryActivityInfo(1);
		ActivityInfo activityInfo=new ActivityInfo();
		activityInfo.setActivityCategory(1);
		activityInfo.setActivityStatus(1);
		activityInfo.setActivityEndtm(new Date());
		activityInfo.setActivityBgntm(new Date());
		List<ActivityInfo> activityInfoList=activityInfoDao.querybyInfo(activityInfo);
		for(int i=0;i<activityInfoList.size();++i) {
			System.out.println(activityInfoList.get(i).getActivityCategory());
		}
		
	}*/
	
	/*@Test
	public void testInsertActivity() {
		ActivityInfo activityInfo=new ActivityInfo();
		activityInfo.setActivityBgntm(new Date());
		activityInfo.setActivityEndtm(new Date());
		activityInfo.setActivityCategory(2);
		activityInfo.setActivityStatus(1);
		activityInfo.setBeginNo("12");
		activityInfo.setCanorderNum(12);
		activityInfo.setLeftorderNum(13);
		activityInfo.setOpenGrade("45");
		activityInfo.setActivityName("123");
		activityInfoDao.insertAppointmentInfo(activityInfo);
	}*/
	/*@Test
	public void testquery() {
		ActivityInfo activityInfo=new ActivityInfo();
		activityInfo.setActivityBgntm(new Date());
		activityInfoDao.queryVolunterInfo(activityInfo);
	}
*/
	@Test
	public void update() {
		ActivityInfo activityInfo=new ActivityInfo();
		activityInfoDao.querybyInfo(activityInfo);
		OrderInfo orderInfo=new OrderInfo();
		orderInfoDao.queryOrderInfo(orderInfo);
		orderInfoDao.queryOrderInfoCount(orderInfo);
	}
/*	@Test
	public void order() {
		ActivityInfo activityInfo=new ActivityInfo();
		
		activityInfoDao.querybyInfo(activityInfo);
		OrderInfo orderInfo=new OrderInfo();
		ActivityInfo activityInfo=new ActivityInfo();
		SystemSet systemSet=new SystemSet();
		activityInfoDao.querybyInfo(activityInfo);
		systemSet.setSysId(1);
		systemsetDao.modifySystemSet(systemSet);
		
	}*/
}
