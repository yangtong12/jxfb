package com.nchu.library.service;

import java.util.List;

import com.nchu.library.entity.OrderInfo;

public interface OrderInfoService {
     /**
      * 查询已预约的活动
      */
	List<OrderInfo> queryOrder(String userNo);
	
	/**
	 * 插入预约的信息
	 */
	int insertOrder(OrderInfo orderInfo,String username);
	/**
	 * 查询预约信息
	 */
	List<OrderInfo> orderInfoList(OrderInfo orderInfo);
	/**
	 * 统计预约数量
	 */
	int queryOrderCount(OrderInfo orderInfo);
	/**
	 * 修改预约信息
	 */
	int updateOrderInfo(OrderInfo orderInfo);
	/**
	 * 删除预约信息
	 */
	int deleteOrderInfo(int orderId);
	/**
	 * 根据名字查询
	 */
	OrderInfo queryByUsername(String userName,int activityId);
}
