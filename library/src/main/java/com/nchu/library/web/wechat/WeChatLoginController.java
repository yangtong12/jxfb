package com.nchu.library.web.wechat;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nchu.library.entity.UserAccessToken;
import com.nchu.library.entity.WeiXinUser;
import com.nchu.library.util.WeChatUserUtil;



@Controller
@RequestMapping("/wechatlogin")
public class WeChatLoginController {


	@RequestMapping(value = "/logincheck", method = { RequestMethod.GET })
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
	
		String code = request.getParameter("code");
		String roleType = request.getParameter("state");
        WeiXinUser user=null;
		String openId = null;
		if (null != code) {
			UserAccessToken token;
			try {
				token = WeChatUserUtil.getUserAccessToken(code);
			
				String accessToken = token.getAccessToken();
				openId = token.getOpenId();
				System.out.println("openId:"+openId);
				user = WeChatUserUtil.getUserInfo(accessToken, openId);
				
				request.getSession().setAttribute("openId", openId);
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
