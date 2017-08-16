<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加视频</title>
<link rel="stylesheet"
	href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/ChinaLife/js/file.js"></script>
</head>
<body>
<div>

		<h1>添加视频</h1>
		<div style="margin-left: 40%">
			<form class="form-inline" role="form"action="/ChinaLife/video/
			add.do" method="post" onsubmit="return checkAll()" enctype="multipart/form-data">
				视频主题:
				 <select name="title">
					<option value="技能培训">技能培训</option>
					<option value="娱乐">娱乐</option>
					<option value="体育">体育</option>
					<option value="美食">美食</option>
				</select><br>
				<div class="form-group">
					视频名称:<input type="text" onblur="checkName()" class="form-control" name="videoName">
				 <br><span style="color: red" id="nameSpan"></span>
				</div><br>
				<div class="form-group">
					主讲人:<input type="text" onblur="checkSp()" class="form-control" name="speaker">
				<br><span style="color: red" id="spSpan"></span>
				</div>
				<div style="height: 30px; width: 10px"></div>
				视频图片：
					<div id="preview" >
						<img id="imghead" width=200 height=200 border=0 src=''>
					</div>	
					<input type="file"  name="img" onchange="previewImage(this,'preview','imghead')" />
					<br><span style="color: red" id="imgSpan"></span>
				<div style="height: 30px; width: 10px"></div>
				视频:<input type="file" name="video" onchange="checkVideo">
				<br><span style="color: red" id="videoSpan"></span>
				<div style="height: 30px; width: 10px"></div>
				<span>员工:</span> <input type=checkbox name="permission" value="员工">
				<span>管理员:</span> <input type=checkbox name="permission" value="管理员">
				<span>系统管理员:</span><input type=checkbox name="permission"
					value="系统管理员"><br> <span>部门负责人:</span><input
					type=checkbox name="permission" value="部门负责人"> <span>领导:</span><input
					type=checkbox name="permission" value="领导"><br>
					<span style="color: red" id="ckSpan"></span><br>
				<button type="submit" class="btn btn-info">发布</button>
				<a href="/ChinaLife/jsp/admin/photo.jsp"
					class="btn btn-primary  active" role="button">返回</a>
			</form>
</div>
</div>
</body>
<script type="text/javascript">
function checkName(){
	var name = $("input[name='videoName']").val();
	var regex = new RegExp("\\S{1,}");
	if(name.match(regex)){
		$("#nameSpan").html("");
		return true
	}else{
		$("#nameSpan").html("请输入视频名称");
		return false
	}
}

function checkSp(){
	var sp = $("input[name='speaker']").val();
	var regex = new RegExp("\\S{1,}");
	if(sp.match(regex)){
		$("#spSpan").html("");
		return true
	}else{
		$("#spSpan").html("请输入主讲人");
		return false
	}
}
function checkImg(){
	var img = $("input[name='img']").val();
	if(img.length != 0){
		$("#imgSpan").html("");
		return true
	}else{
		$("#imgSpan").html("请选择图片");
		return false
	}
}
function checkVideo(){
	var video = $("input[name='video']").val();
	if(video.length != 0){
		$("#videoSpan").html("");
		return true
	}else{
		$("#videoSpan").html("请选择视频");
		return false
	}
}
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
function checkAll(){
	return checkName()&&checkSp()&&checkImg()&&checkVideo()&&checkCk();
}
</script>
</html>