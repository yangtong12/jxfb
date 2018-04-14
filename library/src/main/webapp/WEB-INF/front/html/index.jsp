<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/js/index.js"></script>
<link type="text/css" href="../resources/css/index.css" rel="stylesheet"></link>
</head>
<body style="text-align: center;">
	<div id="outframe">
		<input id="store" value="存包柜预约" type="text" /> <input id="volunteer"
			value="志愿者预约" type="text" /> <input id="speech" value="讲座预约"
			type="text" />
		<div id="cupboard-content">
			<a href="javascript:alert('说明：每个人只能预约一个柜号.预约成功后请在3日内前往图书馆办理相关手续，过期作废。');"><img src="img/aaa.png"></a>
			<span>剩余柜台数量："#{data.msg.canorderNum}" #{data.msg.canorderNum} #{data.msg} #{data}</span>
			<div id="orderedcicle">
				<br><br>
				<p>
					<strong>倒计时</strong>
				</p>
				<p id="time"></p>
			</div>
			<p>下次预约开始时间："#{msgs.nextactivitybgntm}"</p>
			<p>下次预约柜台总数："#{msgs.nextcanordernum}"</p>
		</div>
	</div>
</body>
</html>