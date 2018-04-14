window.onload=function(){
	var perInfoEl=document.getElementById("perInfo");
	var myorderEl=document.getElementById($.cookie('id','my_order'));
	myorderEl.onclick=function(){
		//perInfoEl.style.display="block";
		for(var i=0;i<3;++i	){//var index in msg		
			var ulEl=document.getElementById("orderid");
			
			var liEl=document.createElement("li");
			var activitycategoryEl=document.createElement("p");
			var orderstatusEl=document.createElement("span");
			var ordernoEl=document.createElement("span");
			var activitynameEl=document.createElement("span");
			var ordertmEl=document.createElement("p");
			
			activitycategoryEl.id="activitycategory";
			orderstatusEl.id="orderstatus";
			ordernoEl.id="orderno";
			activitynameEl.id="activityname";
			ordertmEl.id="ordertm";
			
			activitycategoryEl.innerHTML="活动类别:"+data.msg[index].activitycategory;
			orderstatusEl.innerHTML=data.msg[index].orderstatus;
			ordernoEl.innerHTML="编号:"+data.msg[index].userno;
			activitynameEl.innerHTML="活动名称:"+data.msg[index].username;
			ordertmEl.innerHTML="预约时间:"+data.msg[index].ordertm;
			
			liEl.appendChild(activitycategoryEl);
			liEl.appendChild(orderstatusEl);
			liEl.appendChild(ordernoEl);
			liEl.appendChild(activitynameEl);
			liEl.appendChild(ordertmEl);
			
			ulEl.appendChild(liEl);
			console.debug(liEl);
		}
		$.ajax({
	        type: "POST",
	        url: "http://yt.ngrok.xiaomiqiu.cn/library/manage/queryOrderedActivity",
	        data:{userno:$.cookie('userno')},
	        dataType: "json",//一个关键字，用来标识预期将被响应所返回的数据的类型。
	        success: function(data){
	        	if(data.code==0){
	    			
	    			for(var i=0;i<3;++i	){//var index in msg		
	    				var ulEl=document.getElementById("orderid");
	    				
	    				var liEl=document.createElement("li");
	    				var activitycategoryEl=document.createElement("span");
	    				var orderstatusEl=document.createElement("span");
	    				var ordernoEl=document.createElement("span");
	    				var activitynameEl=document.createElement("span");
	    				var ordertmEl=document.createElement("p");
	    				
	    				activitycategoryEl.id="activitycategory";
	    				orderstatusEl.id="orderstatus";
	    				ordernoEl.id="orderno";
	    				activitynameEl.id="activityname";
	    				ordertmEl.id="ordertm";
	    				
	    				activitycategoryEl.innerHTML="活动类别:"+data.msg[index].activitycategory;
	    				orderstatusEl.innerHTML=data.msg[index].orderstatus;
	    				ordernoEl.innerHTML="编号:"+data.msg[index].userno;
	    				activitynameEl.innerHTML="活动名称:"+data.msg[index].username;
	    				ordertmEl.innerHTML="预约时间:"+data.msg[index].ordertm;
	    				
	    				liEl.appendChild(activitycategoryEl);
	    				liEl.appendChild(orderstatusEl);
	    				liEl.appendChild(ordernoEl);
	    				liEl.appendChild(activitynameEl);
	    				liEl.appendChild(ordertmEl);
	    				
	    				ulEl.appendChild(liEl);
	    				console.debug(liEl);
	    			}
	    		}
	         }
	    });	
		
		
	}	
}
