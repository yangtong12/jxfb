window.onload=function(){
	var storeEl=document.getElementById("store");
	var cupboardcontentEl=document.getElementById("cupboard-content");
	
	var m=0;
	var s=50;
	storeEl.onclick=function(){
		
		storeEl.style.backgroundColor="grey";
		
		var clear=setInterval(function(){
			
			cupboardcontentEl.style.display="block";
			var width=document.documentElement.clientWidth;
			var orderedcicleEl=document.getElementById("orderedcicle");
			
			orderedcicleEl.style.height=parseInt(width)/2+'px';
			orderedcicleEl.style.width=orderedcicleEl.style.height;
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
		         //  data: {username:$("#username").val(), content:$("#content").val()},
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
					inputEl.style.border="2px solid black";
					inputEl.style.outline="none";
					inputEl.style.height=parseInt(orderedcicleEl.style.width)*98/100+'px';
					inputEl.style.width=inputEl.style.height;
					inputEl.style.backgroundColor="yellow";
					inputEl.style.borderRadius="50%";
					inputEl.style.fontSize="40px";
					orderedcicleEl.appendChild(inputEl);
					inputEl.onclick=function(){
						inputEl.style.backgroundColor="#FFF68F";
					};
					clearInterval(clear);	
				}
			
			var time=document.getElementById("time");
			time.innerHTML=m+":"+s;
		}, 1000);
	};	
}