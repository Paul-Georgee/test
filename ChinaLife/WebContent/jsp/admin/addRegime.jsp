<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
<link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <style type="text/css">
        .linear{
            background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(rgb(182,231,211)), to(#ffffff));/*谷歌*/
        }

    </style>
</head>
<body>
<div style="background-color: white;width: 70%;height: 500px;margin: auto">
         <div style="text-align: center;height: 70px;width: 100%;margin: auto">
             <h1 style="text-align: left">添加规章制度</h1><br>
         </div>
          <div style="text-align: center;">
			<form action="/ChinaLife/rules/add.do" onsubmit="return checkAll()" method="post">
				<h3>标题:</h3> <span style="color: red" id="nameSpan"></span>
				<input type="text" onblur="checkName()" name="ruleName">
				<h3>内容:</h3><span style="color: red" id="contSpan"></span>
				<textarea rows="8" cols="40" onblur="checkCont()" name="content"></textarea>
				<input type="submit"  value="添加">
				<a href="/ChinaLife/jsp/admin/regime.jsp" class="btn btn-primary btn-lg active" role="button">返回</a>
			</form>
            </div>
</div>
</body>
<script type="text/javascript">
function checkName(){
	var name = $("input[name='ruleName']").val();
	var regex = new RegExp("\\S{1,}");
	if(name.match(regex)){
		$("#nameSpan").html("");
		return true
	}else{
		$("#nameSpan").html("请输入标题");
		return false
	}
}

function checkCont(){
	var content = $("textarea[name='content']").val();
	var regex = new RegExp("\\S{1,}");
	if(content.match(regex)){
		$("#contSpan").html("");
		return true
	}else{
		$("#contSpan").html("请输入内容");
		return false
	}
}

function checkAll(){
	return checkName()&&checkCont()
}
</script>
</html>