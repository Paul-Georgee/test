<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
<link rel="stylesheet"
	href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script type="text/javascript" src="/ChinaLife/js/jquery-1.7.min.js"></script>
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>

<script type="text/javascript">
		
	function checkTel(){
		var str1=$("#tel").val();
		var reg=/^1[3|4|5|7|8][0-9]{9}$/;
		if(str1.length==0||str1.indexOf(" ")!=-1){
			$("#telMages").html("手机号码不能为空或空格输入,重新输入");
			return false;
		}else if(str1.match(reg)){
			$("#telMages").html("");
			return true;
		}else{
			$("#telMages").html("手机号格式不正确,请重新输入");
			return false;	
		}
	}

	function check(){
		return checkTel()&&true;
	}
</script>
</head>
<body>
	<h1>修改用户信息</h1>
	<br>
	<form action="/ChinaLife/emploee/updateUserInfo.do" method="post" class="form-inline" role="form" onsubmit="return check()">
		<div class="row">
			<div class="col-md-2"></div>
				<input type="hidden" name="id" value="${userBinfo.id}">
			<div class="col-md-4">
				<div class="form-group">
					头像：<img src="/ChinaLife/images/${userBinfo.avatar}"
						style="height: 100px; width: 100px;">
				</div>
				<br> <br> <br>
				<div class="form-group">姓名： ${ userBinfo.trueName}</div>
				<br> <br> <br>
				<div class="form-group">性别：${userBinfo.gender }</div>
				<br> <br> <br>
				<div class="form-group">出生日期：${userBinfo.birthday }</div>
				<br> <br> <br>
				<div class="form-group">学历：${userBinfo.education}</div>
			</div>
			<div class="col-md-5">
				<br>
				<div class="form-group">
					职务：<select class="form-control" name="duty">
						<option>业务员</option>
						<option>技术员</option>
						<option>技术总监</option>
						<option>组长</option>
						<option>项目经理</option>
					</select>
				</div>
				<br> <br> <br>
				<div class="form-group">
					联系方式：<input type="text" class="form-control" id="tel" name="tel" value="${userBinfo.tel}" onblur="checkTel()">
					<br><span style="color:red" id="telMages"></span>
				</div>
				<br> <br> <br>
				<div class="form-group">
					所在部门：<select name="departId" class="form-control">
						<c:forEach items="${depart}" var="obj">
							<c:if test="${userBinfo.departId==obj.id}">
							<option value='${obj.id}'selected='selected'>${obj.departName}</option>
							</c:if>
							<option value='${obj.id}'>${obj.departName}</option>
						</c:forEach>
					</select>
				</div>
				<br> <br> <br>
				<div class="form-group">登录名：${userBinfo.username}</div>
				<br> <br> <br>
				<div class="form-group">
					角色：<select name="role" class="form-control">
						<option>业务员</option>
						<option>管理员</option>
						<option>领导</option>
						<option>部门负责人</option>
						<option>系统管理员</option>
					</select>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
		<br> <br>
		<div class="row">
			<div class="col-md-5"></div>
			<div class="col-md-7">
				<button type="submit" class="btn btn-default">
					修改
				</button>
			</div>
		</div>
	</form>
</body>
</html>