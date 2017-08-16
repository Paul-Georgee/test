<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改视频</title>
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
<link rel="stylesheet"
	href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
<style type="text/css">
span {
	font-size: 18px;
}
</style>
</head>
<body>
	
		<div class="row" style="height: 300px; width: 70%; margin: auto;">
			<h1>修改视频</h1>
			<br>
			<br>
			<br>
			<div>
				<span>视频主题:  ${video.title}</span>
			</div>
			<div>
				<span> 主讲人:  ${video.speaker}</span>
			</div>

			<div>
				<span>发布时间:  ${video.publishTime}</span>
			</div>

			<div>
				<span>视频名称:  ${video.videoName}</span>
			</div>
			<br>
			
			<div>
				<span> 权限:</span>
				<form action="/ChinaLife/video/update.do?id= ${video.id}"
				 onsubmit="return checkCk()"  method="post">
					<span>员工:</span> <input type=checkbox name="permission" value="员工">
      				<span>管理员:</span> <input type=checkbox name="permission" value="管理员">
       				<span>系统管理员:</span><input type=checkbox name="permission" value="系统管理员"><br>
       				<span>部门负责人:</span><input type=checkbox name="permission" value="部门负责人">
      				<span>领导:</span><input type=checkbox name="permission" value="领导">
					<div style="margin-left: 35%;margin-top: 180px;">
						<button type="submit" class="btn btn-info">修改</button>
						<a href="/ChinaLife/jsp/admin/photo.jsp"
						class="btn btn-primary  active" role="button">返回</a>
					</div>
				</form>
			</div>
			<div style="position: relative; left: 40%; bottom: 410px;">
				<span> 缩略图:</span><img style="width: 230px; height: 170px;"
					src="/ChinaLife/images/${video.videoAvatar}">
			</div>
		</div><br>
		<span style="color: red;margin-left: 35%;" id="ckSpan"></span>
</body>
<script type="text/javascript">
function checkCk(){
	var ck = document.getElementsByName("permission");
	var objarray=ck.length;
	var chestr="";
	for (i=0;i<objarray;i++){
	 if(ck[i].checked == true) {
	  chestr+=ck[i].value+",";
	 }
	}
	if(chestr == "")
	{
		$("#ckSpan").html("请选择权限");
		return false
	}else{
		$("#ckSpan").html("");
		return true
	}
}
</script>
</html>