window.onload=function(){
		document.getElementById("submitbtn").onclick=function(){
			
			var activityidText=document.getElementById("activitycategory").value;
			var activitystarttmText=document.getElementById("activitystarttm").value;
			var activityendtmText=document.getElementById("activityendtm").value;
			var canordernumText=document.getElementById("canordernum").value;
			var beginnoText=document.getElementById("beginno").value;
			var opengradeText=document.getElementById("leftordernum").value;
			var leftordernumText=document.getElementById("opengrade").value;
			var activitystatusText=document.getElementById("activitystatus").value;
			var activitynameText=document.getElementById("activityname").value;
			
			var trEl=document.createElement("tr");
			
			
			var activityidEl=document.createElement("td");
			var activitystarttmEl=document.createElement("td");
			var activityendtmEl=document.createElement("td");
			var canordernumEl=document.createElement("td");
			var beginnoEl=document.createElement("td");
			var opengradeEl=document.createElement("td");
			var leftordernumEl=document.createElement("td");
			var activitystatusEl=document.createElement("td");
			var activitynameEl=document.createElement("td");

			activityidEl.innerHTML=activityidText;
			activitystarttmEl.innerHTML=activitystarttmText;
			activityendtmEl.innerHTML=activityendtmText;
			canordernumEl.innerHTML=canordernumText;
			 beginnoEl.innerHTML=beginnoText;
			 opengradeEl.innerHTML=opengradeText;
			 leftordernumEl.innerHTML=leftordernumText;
			 activitystatusEl.innerHTML=activitystatusText;
			 activitynameEl.innerHTML=activitynameText;
			 console.debug("activitynameEl");
			  
			 
			 trEl.appendChild(activityidEl);
			 trEl.appendChild(activitystarttmEl);
			 trEl.appendChild(activityendtmEl);
			 trEl.appendChild(canordernumEl);
			 trEl.appendChild(beginnoEl);
			 trEl.appendChild(opengradeEl);
			 trEl.appendChild(leftordernumEl);
			 trEl.appendChild(activitystatusEl);
			 trEl.appendChild(activitynameEl);
			 
			 document.getElementById(cookie('id','activityinfotable')).appendChild(trEl);	
			 
		};
};
