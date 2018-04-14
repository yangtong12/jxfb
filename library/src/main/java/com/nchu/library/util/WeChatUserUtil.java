package com.nchu.library.util;

import java.io.IOException;

import com.nchu.library.entity.UserAccessToken;
import com.nchu.library.entity.WeiXinUser;

import net.sf.json.JSONObject;


public class WeChatUserUtil {
	public static UserAccessToken getUserAccessToken(String code)
			throws IOException {
		String APPID="wx73fb26c5885cc3ca";
		String APPSECRET="e3005941294ea9406efdc2a756675aae";
	
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		requestUrl = requestUrl.replace("APPID", APPID);
	    requestUrl = requestUrl.replace("SECRET", APPSECRET);
	    requestUrl = requestUrl.replace("CODE", code);
		JSONObject jsonObject = WeChatUtil.httpsRequest(requestUrl, "GET", null);
	
		String accessToken = jsonObject.getString("access_token");
		if (null == accessToken) {
		
			return null;
		}
		UserAccessToken token = new UserAccessToken();
		token.setAccessToken(accessToken);
		token.setExpiresIn(jsonObject.getString("expires_in"));
		token.setOpenId(jsonObject.getString("openid"));
		token.setRefreshToken(jsonObject.getString("refresh_token"));
		token.setScope(jsonObject.getString("scope"));
		return token;
	}
	
	public static WeiXinUser getUserInfo(String accessToken, String openId) {
		String url = "https://api.weixin.qq.com/sns/userinfo?access_token="
				+ accessToken + "&openid=" + openId + "&lang=zh_CN";
		JSONObject jsonObject = WeChatUtil.httpsRequest(url, "GET", null);
		WeiXinUser user = new WeiXinUser();
		String openid = jsonObject.getString("openid");
		if (openid == null) {
		
			return null;
		}
		user.setOpenId(openid);
		user.setNickName(jsonObject.getString("nickname"));
		user.setSex(jsonObject.getInt("sex"));
		user.setProvince(jsonObject.getString("province"));
		user.setCity(jsonObject.getString("city"));
		user.setCountry(jsonObject.getString("country"));
		user.setHeadimgurl(jsonObject.getString("headimgurl"));
		user.setPrivilege(null);
		// user.setUnionid(jsonObject.getString("unionid"));
		return user;

}
}
