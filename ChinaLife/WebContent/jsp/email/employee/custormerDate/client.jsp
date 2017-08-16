<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户资料</title>
<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
</head>
<body>


<h1>客户资料</h1><br>

<div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
        
        <!--查询-->
<form class="form-inline" role="form" action="" method="post">
    <div class="form-group">
        姓名： <input type="text" class="form-control"  name="">
    </div>
    <div class="form-group">
        职业：<input type="text" class="form-control"  name="">
    </div>
    <div class="form-group">
        家庭情况：<input type="text" class="form-control"  name="">
    </div>
    <button type="submit" class="btn btn-default">查询</button>
</form><br>

<table class="table table-striped">

    <thead>
    <tr><th>姓名</th><th>性别</th><th>收入</th><th>职业</th><th>联系方式</th><th>操作</th></tr>
    </thead>
    <tbody>
    <tr>
        <td>张三</td>
        <td>男</td>
        <td>5200</td>
        <td>职业</td>
        <td>15825825855</td>
        <td><a href="showClient.jsp">查看</a>&nbsp;<a href="updateClient.jsp">修改</a></td>
    </tr>
    <tr>
        <td>张三</td>
        <td>男</td>
        <td>5200</td>
        <td>职业</td>
        <td>15825825855</td>
        <td>查看</td>
    </tr>
    <tr>
        <td>张三</td>
        <td>男</td>
        <td>5200</td>
        <td>职业</td>
        <td>15825825855</td>
        <td>查看</td>
    </tr>
    <tr>
        <td>张三</td>
        <td>男</td>
        <td>5200</td>
        <td>职业</td>
        <td>15825825855</td>
        <td>查看</td>
    </tr>
    <tr>
        <td>张三</td>
        <td>男</td>
        <td>5200</td>
        <td>职业</td>
        <td>15825825855</td>
        <td>查看</td>
    </tr>
    </tbody>
</table><br>
<a href="addClient.jsp" class="btn btn-primary btn-lg active" role="button">添加客户</a>
        
        </div>
        <div class="col-md-1"></div>
</div>



</body>
</html>