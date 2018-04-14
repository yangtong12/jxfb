$(function(){
	var activityid=getQueryString('activityId');
	QueryActivity(activityid);
	function QueryActivity(activityid){
		$.getJSON('cupboardOrderPage?activityid='+activityid,function(data){
			if(!data.success){
				var data=data.data;
				$('#activityid').val(data.activityId);
				$('#activitybgntm').html(data.activityBgntm);
				$('#activityendtm').html(data.activityEndtm);
				$('#beginno').val(data.beginNo);
				$('#canordernum').val(data.canorderNum);
				$('#opengrade').val(data.openGrade);
				$('#leftordernum').val(data.leftorderNum);
				$('#activitystatus').val(data.activityStatus);
				$('#activityname').val(data.activityName);
			}
		});
	}
	$('#submitbtn').click(function(){
		var activity={};
		activity.activityId=$('#activityid').val();
		activity.activityCategory=$('#activitycategory').val();
		activity.activityBgntm=$('#activitybgntm').val();
		activity.activityEndtm=$('#activityendtm').val();
		activity.beginNo=$('#beginno').val();
		activity.openGrade=$('#opengrade').val();
		activity.leftorderNum=$('#leftordernum').val();
		activity.activityStatus=$('#activitystatus').val();
		activity.canorderNum=$('#canordernum').val();
		activity.activityName=$('#activityname').val();
		var formData=new FormData();
		formData.append('activityStr',JSON.stringify(activity));
		$.ajax({
			url:'/library/manage/modifyActivityInfo',
			type:'POST',
			data:formData,
			contentType:false,
			processData:false,
			success:function(data){
				if(data.code==0){
//					alert("成功！");
					window.parent.location.reload();  
					parent.layer.closeAll('actitableedit.html'); 

				}
			},
			error:function(){
				alert("提交不成功！");
			}
		});

	});
});
