package com.nchu.library.web.wechat;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nchu.library.dto.CodeMsg;
import com.nchu.library.entity.ActivityInfo;
import com.nchu.library.entity.OrderInfo;
import com.nchu.library.entity.SystemSet;
import com.nchu.library.service.ActivityInfoService;
import com.nchu.library.service.OrderInfoService;
import com.nchu.library.service.SystemSetService;
import com.nchu.library.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	@Autowired
	private ActivityInfoService activityInfoService;
	@Autowired
	private SystemSetService systemSetService;
	@Autowired
	private OrderInfoService orderInfoService;

	 @RequestMapping(value = "/cupboardOrderPage", method = RequestMethod.GET)
	    @ResponseBody
		private Map<String,Object> appointment(Model model , HttpServletRequest request) {
	    	Map<String,Object> modelMap=new HashMap<String,Object>();
			int activityid=HttpServletRequestUtil.getInt(request,"activityid");
			try {
				ActivityInfo activitylist=activityInfoService.getActivityInfo(activityid);
				modelMap.put("success",CodeMsg.SUCCESS);
				modelMap.put("data",activitylist);
			}catch(Exception e) {
				modelMap.put("code",CodeMsg.FAILURE);
				modelMap.put("errMsg",e.toString());
			}
			return modelMap;
	    }
	@RequestMapping(value = "/queryActivityinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> queryActivityinfo(Model model,HttpServletRequest request) {
		Map<String,Object> modelMap=new LinkedHashMap<String,Object>();
		ActivityInfo activityInfo=new ActivityInfo();
		activityInfo.setActivityId(1);
		activityInfo.setActivityStatus(1);
		List<ActivityInfo> activityInfoList=null;
		int count=0;
		try {
			activityInfoList=activityInfoService.queryManage(activityInfo);
			count=activityInfoService.queryActivityCount(activityInfo);
			modelMap.put("code",CodeMsg.SUCCESS);
			modelMap.put("msg","");
			modelMap.put("count",count);
			modelMap.put("data",activityInfoList);
			model.addAttribute(modelMap);
		}catch(Exception e) {
			modelMap.put("code",CodeMsg.FAILURE);
			modelMap.put("errMsg",e.toString());
		}
		return modelMap;
	}
	
	@RequestMapping(value="/querySystemSet",method=RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> querySystemSet(Model model) {
		Map<String,Object> modelMap=new HashMap<String,Object>();
		SystemSet systemSet=new SystemSet();
		int count=0;
		try {
			List<SystemSet> sysSet=systemSetService.querySystem();
			count=systemSetService.querySystemCount(systemSet);
		    modelMap.put("code",CodeMsg.SUCCESS);
		    modelMap.put("msg","");
		    modelMap.put("count",count);
		    modelMap.put("data",sysSet);
		}catch(Exception e) {
			modelMap.put("code",CodeMsg.FAILURE);
			modelMap.put("errMsg",e.toString());
		}
		return modelMap;
	}
	
	@RequestMapping(value="/addActivityInfo",method=RequestMethod.POST)
	@ResponseBody
	private Map<String,Object> addActivityInfo(Model model,HttpServletRequest request) {
		Map<String,Object> modelMap=new HashMap<String,Object>();
		//1.接收并转化相应的参数,包括店铺信息以及图片信息
		String activityStr=HttpServletRequestUtil.getString(request,"activityStr");
		ObjectMapper mapper=new ObjectMapper();
		ActivityInfo activityInfo=null;
		try{
			activityInfo=mapper.readValue(activityStr,ActivityInfo.class);
		}catch(Exception e){
			modelMap.put("success",false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		int effNum=activityInfoService.addActivityInfo(activityInfo);
		if(effNum>0) {
			modelMap.put("code",CodeMsg.SUCCESS);
		}else {
			modelMap.put("code",CodeMsg.FAILURE);
		}
		return modelMap;
	}
	
	@RequestMapping(value="/deleteActivityInfo")
	@ResponseBody
	private Map<String,Object> deleteActivityInfo(HttpServletRequest request){
		Map<String,Object> modelMap=new HashMap<String,Object>();
		int activityid=HttpServletRequestUtil.getInt(request,"activityid");
		int effNum=0;
		try{
			effNum=activityInfoService.deleteActivity(activityid);
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
	
	@RequestMapping(value="/modifyActivityInfo",method=RequestMethod.POST)
	@ResponseBody
	private Map<String,Object> modifyActivityInfo(HttpServletRequest request){
		Map<String,Object> modelMap=new HashMap<String,Object>();
		String activityStr=HttpServletRequestUtil.getString(request,"activityStr");
		ObjectMapper mapper=new ObjectMapper();
		int effNum=0;
		ActivityInfo activityInfo=null;
		try{
			activityInfo=mapper.readValue(activityStr,ActivityInfo.class);
		}catch(Exception e){
			modelMap.put("success",false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		effNum=activityInfoService.updateActivity(activityInfo);
		if(effNum>0) {
			modelMap.put("code",CodeMsg.SUCCESS);
		}else {
			modelMap.put("code",CodeMsg.FAILURE);
		}
		return modelMap;
	}
	
	@RequestMapping(value="/queryOrderInfo",method=RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> queryOrderInfo(Model model,HttpServletRequest request,OrderInfo orderInfo) {
		Map<String,Object> modelMap=new HashMap<String,Object>();
		try {
			List<OrderInfo> orderInfoList=orderInfoService.orderInfoList(orderInfo);
			int count=orderInfoService.queryOrderCount(orderInfo);
			modelMap.put("code",CodeMsg.SUCCESS);
			modelMap.put("data",orderInfoList);
			modelMap.put("msg","");
			modelMap.put("count",count);
		}catch(Exception e) {
			modelMap.put("code",CodeMsg.FAILURE);
			modelMap.put("errMsg",e.getMessage());
		}
		return modelMap;
	}
}
