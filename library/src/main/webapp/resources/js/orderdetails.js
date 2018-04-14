window.onload=function(){ 
	
	layui.use('table', function(){                                                                                                
    var table = layui.table;                                                                                                      
    table.render({                                                                                                                
        elem: '#orderinfo'                                                                                                             
        ,url:'queryOrderInfo'  
        ,cellMinWidth: 80
        ,cols: [[  
        	  {type:'checkbox', fixed: 'left'}
        	 ,{field:'orderId', title: '已预约列表id'}
             ,{field:'activityId', title: '预约活动id'}
 		    ,{field:'userNo', title: '用户学号'}
 		    ,{field:'userName', title: '用户姓名'}
 		    ,{field:'userqq', title: '用户QQ'}
 		    ,{field:'orderTm',  title: '预约成功的时间'}
 		    ,{field:'orderStatus', title: '预约状态'}
 		    ,{field:'orderNo',  title: '预约号'}
 		    ,{field:'orderMemo',title: '预约数量',fixed: 'right'}
 		    ,{width:190, title: '操作',align:'center', toolbar:"#barDemo",fixed:"right"}
 		    ]]                                                                                                                  
            ,page: true                                                                                                           
        });
	 });
	
	
	layui.use('table', function(){
		  var table = layui.table;
		  //监听表格复选框选择
		  table.on('checkbox(demo)', function(obj){
		    console.log(obj)
		  });
		  //监听工具条
		  table.on('tool(demo)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'detail'){
		      layer.msg('ID：'+ data.orderId + ' 的查看操作');
		    }else if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			    	  $.ajax({
			    		 url:"deleteActivityInfo",
			    		 type:"POST",
			    		 dataType:"json",
			    		 data:{
			    			 activityid:data.activityId,
			    		 },
			    		 success:function(data){
			    			 if(data.code==0){
			    				 layer.msg("删除成功");
			    				 obj.del(); //删除对应行（tr）的DOM结构
			    			     layer.close(index);
			    			 }else{
			    				 layer.msg("删除失败!");
			    			 }
			    		 }
			    		 
			    	  });
			        
			        //向服务端发送删除指令
			      });
			    } 
		    else if(obj.event === 'edit'){
		    	 layer.open({
		             type: 2,
		 		    title: '预约详情编辑',
		 		    maxmin: true,
		 		    shadeClose: true, //点击遮罩关闭层
		 		    area : ['800px' , '520px'],
		 		    content: 'detatableedit.html'
		 		    });
		    }
		  });
		  
		  var $ = layui.$, active = {
		    getCheckData: function(){ //获取选中数据
		      var checkStatus = table.checkStatus('orderinfo')
		      ,data = checkStatus.data;
		      layer.alert(JSON.stringify(data));
		    }
		    ,getCheckLength: function(){ //获取选中数目
		      var checkStatus = table.checkStatus('orderinfo')
		      ,data = checkStatus.data;
		      layer.msg('选中了：'+ data.length + ' 个');
		    }
		    ,isAll: function(){ //验证是否全选
		      var checkStatus = table.checkStatus('orderinfo');
		      layer.msg(checkStatus.isAll ? '全选': '未全选')
		    }
		  };
		  
		  $('.demoTable .layui-btn').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });
		});
} 

