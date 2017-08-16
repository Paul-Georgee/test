<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script type="text/javascript" src="/ChinaLife/js/jquery-1.7.min.js"></script>
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>


<script type="text/javascript">
	function checkhead(){
		var head=$("#head").val();
		if(head.length==0){
			$("#headMsg").html("请选择头像");
			return false;
		}else{
			$("#headMsg").html("");
			return true;
		}
	}
	 
	function  checkName(){
		var trueName=$("#trueName").val();
		if(trueName.length==0||trueName.indexOf(" ")!=-1||trueName.length<2||trueName.length>10){
			$("#nameMsg").html("昵称不能为空或空格输入,请您输入长度为3-10");
			return false;
		}else{
			$("#nameMsg").html("");
			return true;
		}
	}
	
	
	function checkBirthday(){
		var birthday=$("#birthday").val();
		if(birthday.length==0){
			$("#birthdayMsg").html("生日不能为空");
			return false;
		}else{
			$("#birthdayMsg").html("");
			return true;
		}	
	}

	
	function checkTel(){
		var tel=$("#tel").val();
		if(tel.length==0||tel.indexOf(" ")!=-1){
			$("#telMsg").html("手机号不能为空或有空格输入")
			return false;
		}else if(tel.match(/^1[3|5|7|8][0-9]{9}/)){
			$("#telMsg").html("");
			return true;
		}else{
			$("#telMsg").html("手机号格式不正确");
			return false;
	}
	}
	
	
	function checkUName(){
		var username=$("#username").val();
		if(username.length==0||username.length<5||username.length>12||username.indexOf(" ")!=-1){
			$("#unameMsg").html("用户名不能为空或空格输入,长度大于4小于12");
			return false;
		}else{
			$("#unameMsg").html("");
			return true;
		}
		
	}
	
	function checkEmail(){
		var email=$("#email").val();
		if(email.length==0||email.indexOf(" ")!=-1){
			$("#emailMsg").html("邮箱不能为空或空格输入,请输入");
			return false;
		}else{
			$("#emailMsg").html("");
			return true;
		}
	}
	
	function check(){
		return  checkhead()&&checkName()&&checkBirthday()&&checkTel()&&checkUName()&&checkEmail();
	}
</script>


</head>
<body>
<h1>添加用户</h1><br>

<form action="/ChinaLife/emploee/addUser.do" method="post" class="form-inline" role="form" enctype="multipart/form-data"  onsubmit="return check()">

    <div class="row">
    <div class="col-md-2"></div>

    <div class="col-md-4">
        <div class="form-group">
            头像：<input type="file" id="head" name="head" onblur="checkhead()">
         <span id="headMsg" style="color:red"></span>
        </div><br><br>
        <div class="form-group">
            姓名： <input type="text" class="form-control"  id="trueName"  name="trueName" onblur="checkName()">
        <br><span id="nameMsg" style="color:red"></span>
        </div><br><br>
        <div class="form-group">
            性别：&nbsp; <input type="radio" name="gender" checked="checked" value="男"> 男 &nbsp; <input type="radio" name="gender" value="女">女
        </div><br><br>
        <div class="form-group">
            出生日期：<input type="date" class="form-control" id="birthday" name="birthday" onblur="checkBirthday()">
        <br><span id="birthdayMsg" style="color:red"></span>
        </div><br><br>
        <div class="form-group">
            学历：<select class="form-control" name="education">
            <option>大专</option>
            <option>本科</option>
            <option>研究生</option>
            <option>博士</option>   
        </select>
        </div>
        
    </div>

    <div class="col-md-5"><br>
        <div class="form-group">
            职务：<select class="form-control" name="duty">
            <option>业务员</option>
            <option>技术员</option>
            <option>技术总监</option>
            <option>组长</option>
            <option>项目经理</option>
        </select>
        </div><br><br>
        <div class="form-group">
            联系方式：<input type="text" class="form-control"  id="tel" name="tel" onblur="checkTel()">
       		<br> <span id="telMsg" style="color:red"></span>
        </div><br><br>
        <div class="form-group">
            所在部门：<select name="departId" class="form-control">
            <c:forEach items="${depart}" var="obj">
            	<option  value='${obj.id}'>${obj.departName}</option>
            </c:forEach>
        </select>
        </div><br><br>
        <div class="form-group">
            登录名：<input type="text" class="form-control"  id="username" name="username" onblur="checkUName()">
       <br> <span id="unameMsg" style="color:red"></span>
        </div><br><br>
        <div class="form-group">
            邮箱：<input type="email" class="form-control"  id="email" name="email" onblur="checkEmail()">
        <br> <span id="emailMsg" style="color:red"></span>
        </div><br><br>
    </div>
    <div class="col-md-1"></div>
    </div>
<br><br>

    <div class="row">
        <div class="col-md-5"></div>
        <div class="col-md-7">
            <button type="submit" class="btn btn-default" >添加</button>
        </div>
    </div>

</form>

</body>
</html>