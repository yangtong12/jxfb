package com.nchu.chjxfb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.nchu.chjxfb.domin.UserInfo;

@Mapper
public interface UserInfoDao {
	
	@Select("select * from user_info where user_name=#{userName} AND password=#{password}")
	public int Login(UserInfo userInfo);

}
