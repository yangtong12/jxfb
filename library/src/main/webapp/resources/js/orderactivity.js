window.onload=function(){
	
	layui.use('table', function(){
    var table = layui.table;
    table.render({
        elem: '#activityinfo'
        ,url:'queryActivityinfo'
        ,cellMinWidth: 80
        ,response:{
        	  code: 0,
        	  msg: "",
        	  data: []
        	} 
        ,cols: [[
        	  {type:'checkbox', fixed: 'left'}
        	/* ,{field:'activityId', width:100, title: '预约活动id'} */                                                         
              ,{field:'activityCategory', title: '预约类别'}   
              ,{field:'activityName',  title: '活动名称'} 
  		    ,{field:'activityBgntm',  title: '开始时间',templet:'#activityBgntm' }                                                         
  		    ,{field:'activityEndtm',  title: '结束时间',templet:'#activityEndtm'}                                                                     
  		    ,{field:'beginNo', title: '编号前缀'}                                                            
  		    ,{field:'canorderNum', title: '可预约总数'}                                                                 
  		    ,{field:'openGrade', title: '开放预约年级'}                                                           
  		  /*  ,{field:'leftorderNum', width:140, title: '剩余可预约数量'}    */                                                               
  		    ,{field:'activityStatus',width:90,title: '活动状态'}                                                       
  		    ,{width:190, title: '操作',align:'center',fixed: 'right', toolbar:"#barDemo"}

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
		      layer.msg('ID：'+ data.activityId + ' 的查看操作');
		    } else if(obj.event === 'del'){
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
		      });
		    } 
		    else if(obj.event === 'edit'){
		    	 layer.open({
		             type: 2,
		 		    title: '预约活动编辑',
		 		    maxmin: true,
		 		    shadeClose: true, //点击遮罩关闭层
		 		    area : ['800px' , '520px'],
		 		    content: 'actitableedit.html?activityId='+data.activityId
		 		    });
		    } 
		  }); 
		  
		  var $ = layui.$, active = {
		    getCheckData: function(){ //获取选中数据
		      var checkStatus = table.checkStatus('activityinfo')
		      ,data = checkStatus.data;
		      layer.alert(JSON.stringify(data));
		    }
		    ,getCheckLength: function(){ //获取选中数目
		      var checkStatus = table.checkStatus('activityinfo')
		      ,data = checkStatus.data;
		      layer.msg('选中了：'+ data.length + ' 个');
		    }
		    ,isAll: function(){ //验证是否全选
		      var checkStatus = table.checkStatus('activityinfo');
		      layer.msg(checkStatus.isAll ? '全选': '未全选')
		    }
		  };
		  
		  $('.demoTable .layui-btn').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });
		});
	

}
/*table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
var data = obj.data //获得当前行数据
,layEvent = obj.event; //获得 lay-event 对应的值
if(layEvent === 'detail'){
	 layer.msg('ID：'+ data.activityId + ' 的查看操作');
} 
	    else if(layEvent === 'del'){
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
else if(layEvent === 'edit'){
	 layer.open({
         type: 2,
		    title: 'iframe编辑操作',
		    maxmin: true,
		    shadeClose: true, //点击遮罩关闭层
		    area : ['800px' , '520px'],
		    content: 'actitableedit.html?activityId='+data.activityId
		    });
}
});
});*/

	