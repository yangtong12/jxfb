window.onload=function(){
	var minutes;
	var seconds;
	var hour;

	var width=document.documentElement.clientWidth;
	var orderedcicleEl=document.getElementById("orderedcicle");
	
	orderedcicleEl.style.height=parseInt(width)/2+'px';
	orderedcicleEl.style.width=orderedcicleEl.style.height;
	
	window.onresize=function(){
		var width=document.documentElement.clientWidth;
		var orderedcicleEl=document.getElementById("orderedcicle");
		
		orderedcicleEl.style.height=parseInt(width)/2+'px';
		orderedcicleEl.style.width=orderedcicleEl.style.height;
		
		if(minutes==0 && seconds==0){
				var inputEl =document.getElementById("start");
				inputEl.style.height=parseInt(orderedcicleEl.style.height)*98/100+'px';
				inputEl.style.width=inputEl.style.height;
			}
		
	};
	setInterval(function(){
		$.ajax({
	        type: "POST",
	        url: "/library/front/queryOrderCountDown",
	        data:{userno:$.cookie('userno')},
	        dataType: "json",
	        success: function(data){
	                    hour=data.hour;
	                    minutes=data.minutes;
	                    second=data.seconds;
	                 }
	    });
	}, 1800000);
	
	$.ajax({
        type: "POST",
        url: "/library/front/cupboardOrderPage",
        data:{
        	activityid:1,
        },
        dataType: "json",
        success: function(data){
                    $("#canorderednum").text('剩余柜台数量：'+data.data.canorderNum);
                    $("#nextactivitybgntm").text('下次预约开始时间：'+data.data.activityBgntm);
                    $("#nextcanordernum").text('下次预约柜台总数：'+data.data.canorderNum);
                 }
    });
	
	if(hour<1){
		var clear=setInterval(function(){
			if(seconds==0)
			{
				minutes-=1;
				seconds=60;
			}
			if(seconds<=60)
				seconds-=1;
			if(minutes==0 && seconds==(parseInt(Math.random()*20-10)+30))
			{
				
				$.ajax({
			        type: "POST",
			        url: "/library/front/queryOrderCountDown",
			        data:{userno:$.cookie('userno')},
			        dataType: "json",
			        success: function(data){
			                    seconds=data.seconds;
			                 }
			    });
			}
			if(minutes==0 && seconds==0)
				{
					orderedcicle.innerHTML="";
					orderedcicle.style.border="none";
					orderedcicle.style.backgroundColor="white" ;
					var inputEl=document.createElement("input");
					inputEl.id="start";
					inputEl.type="button";
					inputEl.value="开始";
					inputEl.style.border="2px solid #FFE1FF";
					inputEl.style.borderRadius="50%";
					inputEl.style.outline="none";
					inputEl.style.height=parseInt(orderedcicleEl.style.width)*98/100+'px';
					inputEl.style.width=inputEl.style.height;
					inputEl.style.backgroundColor="yellow";
					inputEl.style.color="blue";
					inputEl.style.fontSize="3rem";
					inputEl.style.backgroundImage="radial-gradient(ellipse at center,#ff0,#FA8072)";
					orderedcicleEl.appendChild(inputEl);
					
					inputEl.onclick=function(){
						inputEl.style.backgroundImage="radial-gradient(ellipse at center,#FFF68F,#FA8072)";
					};
					clearInterval(clear);	
				}
			
				var time=document.getElementById("time");
				if(time!=null)
					time.innerHTML=minutes+":"+seconds;
		}, 1000);
	}
	else {
		var spanEl=document.createElement("span");
		spanEl.innerHTML="预约活动尚未开始";
		spanEl.style.fontSize="1rem";
		orderedcicleEl.appendChild(spanEl);
	}
		
}
