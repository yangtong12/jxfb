window.onload = function() {
	var storeEl=document.getElementById("store");
	var cupboardcontentEl=document.getElementById("cupboard-content");
	
	var m=0;
	var s=10;
	
	var width=document.documentElement.clientWidth;
	var orderedcicleEl=document.getElementById("orderedcicle");
	
	orderedcicleEl.style.height=parseInt(width)/2+'px';
	orderedcicleEl.style.width=orderedcicleEl.style.height;
	
	window.onresize=function(){
		var width=document.documentElement.clientWidth;
		var orderedcicleEl=document.getElementById("orderedcicle");
		
		orderedcicleEl.style.height=parseInt(width)/2+'px';
		orderedcicleEl.style.width=orderedcicleEl.style.height;
		
		if(m==0 && s==0){
				var inputEl =document.getElementById("start");
				inputEl.style.height=parseInt(orderedcicleEl.style.height)*98/100+'px';
				inputEl.style.width=inputEl.style.height;
			}
		
	};
	
	storeEl.onclick=function(){
		storeEl.style.backgroundColor="grey";
		cupboardcontentEl.style.display="block";
		
		var clear=setInterval(function(){
			if(s==0)
			{
				m-=1;
				s=60;
			}
			if(s<=60)
				s-=1;
			if(m==0 && s==(parseInt(Math.random()*20-10)+30))
			{
				$.ajax({
		             type: "POST",
		             url: "/library/front/cupboardOrderPage",
		         //    data: {username:$("#username").val(), content:$("#content").val()},
		             dataType: "json",
		             success: function(data){
		                         s=data;
		                      }
		         });
			}
			if(m==0 && s==0)
				{
					orderedcicle.innerHTML="";
					var inputEl=document.createElement("input");
					inputEl.id="start";
					inputEl.type="button";
					inputEl.value="开始";
					inputEl.style.border="2px solid red";
					inputEl.style.borderRadius="50%";
					inputEl.style.outline="none";
					inputEl.style.height=parseInt(orderedcicleEl.style.width)*98/100+'px';
					inputEl.style.width=inputEl.style.height;
					inputEl.style.backgroundColor="yellow";
					inputEl.style.color="blue";
					inputEl.style.fontSize="60px";
					inputEl.style.backgroundImage="radial-gradient(ellipse at center,#ff0,#FA8072)";
					orderedcicleEl.appendChild(inputEl);
					
					inputEl.onclick=function(){
						//inputEl.style.backgroundColor="#FFF68F";
						inputEl.style.backgroundImage="radial-gradient(ellipse at center,#FFF68F,#FA8072)";
					};
					clearInterval(clear);	
				}
			
				var time=document.getElementById("time");
				if(time!=null)
					time.innerHTML=m+":"+s;
		}, 1000);
}
};