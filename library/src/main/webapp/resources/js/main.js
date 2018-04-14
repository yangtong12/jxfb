window.onload = function() {
	
	/*
	 * 选项卡的切换
	 */
	$.cookie(document.getElementById("my_order"));
	layui.use('element', function(){
		  var element = layui.element;
		  
		  //获取hash来切换选项卡，假设当前地址的hash为lay-id对应的值
		  var layid = location.hash.replace(/^#page=/, '');
		  element.tabChange('page', layid); 
		  
		  //监听Tab切换，以改变地址hash值
		  element.on('tab(page)', function(){
		    location.hash = 'page='+ this.getAttribute('lay-id');
		  });
		  
		});
	
	$('').on('click',function(){
		 $.ajax( {
	      type: "POST",
	      dataType: "json",
	      url: "/dede/templets/default/china_city.php",
	      data: {
	         "region": val
	      },
	      success: function( data ){},
	      error: function( XMLHttpRequest, textStatus )
	      {
	         alert( XMLHttpRequest.status );
	         alert( XMLHttpRequest.readyState );
	         alert( textStatus );
	      }
	   } );

	});
	
};
function a(){alert(123);}
