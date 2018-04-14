package com.nchu.library.web.wechat;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nchu.library.dto.CodeMsg;
import com.nchu.library.entity.OrderInfo;
import com.nchu.library.service.OrderInfoService;
import com.nchu.library.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/manage")
public class OrderManageController {
	@Autowired
	private OrderInfoService orderInfoService;
	
	@RequestMapping(value = "/updateOrderinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> updateOrderInfo(HttpServletRequest request){
		Map<String,Object> modelMap=new HashMap<String, Object>();
	    String orderStr=HttpServletRequestUtil.getString(request,"orderStr");
	    ObjectMapper mapper=new ObjectMapper();
	    OrderInfo orderInfo=null;
	    try {
	    	orderInfo=mapper.readValue(orderStr,OrderInfo.class);
	    }catch(Exception e) {
	    	modelMap.put("success",CodeMsg.FAILURE);
	    	return modelMap;
	    }
		int effNum=orderInfoService.updateOrderInfo(orderInfo);
		if(effNum>0) {
			modelMap.put("code",CodeMsg.SUCCESS);
		}else {
			modelMap.put("code",CodeMsg.FAILURE);
		}
		return modelMap;
	}
	
	
	@RequestMapping(value = "/deleteOrderinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> deleteOrderInfo(HttpServletRequest request){
		Map<String,Object> modelMap=new HashMap<String,Object>();
		int orderid=HttpServletRequestUtil.getInt(request,"orderid");
		int effNum=0;
		try{
			effNum=orderInfoService.deleteOrderInfo(orderid);
			if(effNum>0) {
				modelMap.put("code",CodeMsg.SUCCESS);
			}else {
				modelMap.put("code",CodeMsg.FAILURE);
			}
		}catch(Exception e) {
			modelMap.put("code",CodeMsg.FAILURE);
			modelMap.put("errMsg",e.getMessage());
		}

		return modelMap;
	}
	@RequestMapping(value = "/addOrderinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> addOrderInfo(HttpServletRequest request){
		Map<String,Object> modelMap=new HashMap<String,Object>();
		String orderStr=HttpServletRequestUtil.getString(request,"orderStr");
		String username="yt";
		ObjectMapper mapper=new ObjectMapper();
		OrderInfo orderInfo=null;
		try {
			orderInfo=mapper.readValue(orderStr,OrderInfo.class);
		}catch(Exception e) {
			modelMap.put("success",false);
			modelMap.put("errMsg",e.getMessage());
			return modelMap;
		}
		int effNum=orderInfoService.insertOrder(orderInfo, username);
		if(effNum>0) {
			modelMap.put("success",CodeMsg.SUCCESS);
		}else {
			modelMap.put("success",CodeMsg.FAILURE);
		}

		return modelMap;
	}

}
