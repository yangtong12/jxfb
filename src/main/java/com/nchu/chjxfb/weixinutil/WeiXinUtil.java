package com.nchu.chjxfb.weixinutil;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.nchu.chjxfb.weixin.entity.AccessToken;
import com.nchu.chjxfb.weixin.entity.Button;
import com.nchu.chjxfb.weixin.entity.ClickButton;
import com.nchu.chjxfb.weixin.entity.Menu;
import com.nchu.chjxfb.weixin.entity.ViewButton;

import net.sf.json.JSONObject;

public class WeiXinUtil {
	static String APPID="wxb35bd4a3432e54d7";
	static String APPSECRET="608a9ea277d15cf9c77ade4d12223392";
	private static final String ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static final String CREATE_MENU_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	public static JSONObject doGetStr(String url){
		//	@SuppressWarnings("deprecation")
		//	DefaultHttpClient httpclient=new DefaultHttpClient();
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet=new HttpGet(url);
			
			JSONObject jsonObject=null;
			try {
				HttpResponse response=httpclient.execute(httpGet);
				HttpEntity entity=response.getEntity();
				if(entity!=null){
					String result=EntityUtils.toString(entity,"UTF-8");
					jsonObject=JSONObject.fromObject(result);
				}
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return jsonObject;
		}
	/**
	 * post请求
	 * @param url
	 * @param outStr
	 * @return
	 */
	public static JSONObject doPostStr(String url,String outStr){
		//DefaultHttpClient httpClient=new DefaultHttpClient();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost=new HttpPost(url);
		JSONObject jsonObject=null;
		try{
			httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
			HttpResponse response=httpClient.execute(httpPost);
			String result=EntityUtils.toString(response.getEntity(),"UTF-8");
			jsonObject=JSONObject.fromObject(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonObject;
	}
	/**
	 * 获取access_token
	 * @return
	 */
	public static AccessToken getAccessToken(){
		AccessToken token=new AccessToken();
		String url=ACCESS_TOKEN_URL.replace("APPID",APPID).replace("APPSECRET", APPSECRET);    
		JSONObject jsonObject=doGetStr(url);
		if (jsonObject!=null) {
			token.setToken(jsonObject.getString("access_token"));
			token.setExpiresIn(jsonObject.getInt("expires_in"));
			
		}
		return token;
	}
	
	/**
	 * 组装菜单
	 * @return
	 */
	
	public static Menu initmenu(){
		
		Menu menu=new Menu();
		ViewButton button11=new ViewButton();
		button11.setName("教务系统");
		button11.setType("view");
		button11.setUrl("http://www.baidu.com");
		
	
		ClickButton button21=new ClickButton();
		button21.setName("创新创业新闻");
		button21.setType("click");
		button21.setKey("21");
		
		ClickButton button22=new ClickButton();
		button22.setName("创新创业政策");
		button22.setType("click");
		button22.setKey("22");
		
		
		ClickButton button23=new ClickButton();
		button23.setName("创新创业培训");
		button23.setType("click");
		button23.setKey("23");
		
		
		
		Button button=new Button();
		button.setName("双创教育");
        button.setSub_button(new Button[]{button21,button22,button23});    
		
		menu.setButton(new Button[]{button11,button});    
		return menu;
	}
	
	public static int createMenu(String token,String menu){
		int result=0;
		String url=CREATE_MENU_URL.replace("ACCESS_TOKEN",token);
		JSONObject jsonObject=doPostStr(url,menu);
		if (jsonObject!=null) {
			result=jsonObject.getInt("errcode");
		}
		return result;
	}

}
