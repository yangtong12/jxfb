package com.nchu.library.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nchu.library.entity.OrderInfo;

public interface OrderInfoDao {
	
	/**
	 * 查询以预约的活动
	 */
	List<OrderInfo> queryOrderInfoList(String userNo);
	/**
	 * 插入预约的信息
	 * @return
	 */
	int insertOrderInfo(OrderInfo orderInfo);
	/**
	 * 查询已预约信息
	 */
   List<OrderInfo> queryOrderInfo(@Param("orderInfo")OrderInfo orderInfo);
   /**
    * 计算预约的数量
    */
   int queryOrderInfoCount(@Param("orderInfo")OrderInfo orderInfo);
   /**
    * 更改预约信息
    */
   int updateOrderInfo(OrderInfo orderInfo);
   /**
    * 删除预约信息
    */
   int deleteOrderInfo(int orderId);
   /**
    * 根据姓名和Id查询
    */
   OrderInfo queryByName(String userName,int activityId);

}
