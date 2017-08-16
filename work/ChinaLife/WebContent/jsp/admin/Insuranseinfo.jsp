<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>险种修改</title>
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <style type="text/css">
        span{
            font-size: 20px;
        }
    </style>
</head>
<body>
    <div class="row"style="height: 300px;width: 70%;margin: auto;">
        <h1>修改险种信息</h1>
        <div style="margin: auto;height: 50px;width: 800px;"></div>
        <div class="col-md-1" ></div>
        <div class="col-md-6" >
            <span>险种名称:</span><span>意外伤害保险</span>
        </div>
        <div class="col-md-5" >
            <span>保险类型:</span><span>人身保险</span>
        </div>
        <div style="margin: auto;height: 70px;width: 800px;"></div>
        <div class="col-md-1" ></div>
        <div class="col-md-6" >
            <span>资费:</span><span>20000</span><span>/年</span>
        </div>
        <c:if test="${employee.role=='管理员' or  employee.role=='领导' or employee.role=='超级管理员' }">
	        <div class="col-md-5" >
	            <span>险种状态:</span><span>有效</span>
	        </div>
        </c:if>
        <div style="margin: auto;height: 70px;width: 800px;"></div>
        <div class="col-md-1" ></div>
        <div class="col-md-9" style="height: 300px">
            <span>保险范围:</span>
            <textarea class="form-control" rows="10" cols="50"></textarea>
        </div>
        <div style="margin: auto;height: 70px;width: 800px;"></div>
        <div class="col-md-5" ></div>
        
        <div class="col-md-7" >
        <c:if test="${employee.role=='管理员' or  employee.role=='领导'}">
            <button type="button" class="btn btn-primary" onclick="go()">设为无效</button>
        </c:if>
            <a type="button" class="btn btn-primary" href="javascript:history.back(-1)">返回</a>
        </div>
    </div>
</body>
</html>