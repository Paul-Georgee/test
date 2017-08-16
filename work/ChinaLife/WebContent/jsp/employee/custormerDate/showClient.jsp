<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户</title>
<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
</head>
<body>

<h1>客服详情资料</h1><br>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-4">
            姓名： ${client.clientName}<br><br>
        
            性别：${client.gender}<br><br>
        
            生日：${client.birthday}<br><br>       
       
            收入：${client.salary}/月<br><br>
    </div>
    <div class="col-md-5">
        
            职业：${client.profession}<br><br><br>
               
            联系方式：${client.tel}<br><br><br>
        
            家庭情况：${client.family}<br><br>
    </div>
    <div class="col-md-1"></div>
</div><br>

<div class="row">
    <div class="col-md-5"></div>
    <div class="col-md-7">
       <a href="/ChinaLife/jsp/employee/custormerDate/client.jsp" class="btn btn-primary btn-lg active" role="button">返回</a>

    </div>
</div>


</body>
</html>