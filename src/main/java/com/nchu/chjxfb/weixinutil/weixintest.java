package com.nchu.chjxfb.weixinutil;

import com.nchu.chjxfb.weixin.entity.AccessToken;

import net.sf.json.JSONObject;

public class weixintest {
	public static void main(String[] args) {
		AccessToken token=WeiXinUtil.getAccessToken();
		System.out.println("票据:"+token.getToken());
		System.out.println("有效时间:"+token.getExpiresIn());
		
		String menu=JSONObject.fromObject(WeiXinUtil.initmenu()).toString();
		int result=WeiXinUtil.createMenu(token.getToken(), menu);
		if (result==0) {
			System.out.println("创建菜单成功");
		}else{
			System.out.println("错误码:"+result);
		}
	}

}
