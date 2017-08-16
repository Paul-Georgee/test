<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>添加险种</title>
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
</head>
<body>
<div style="height: 300px;width: 70%;margin: auto">
    <h1>添加险种信息</h1>
    <div style="margin: auto;height: 50px;width: 800px;"></div>
    <div style="margin: auto;height: 600px;width: 800px;">
        <form class="form-inline" role="form">
            险种:
            <div class="form-group">
                <input type="text" class="form-control" >
            </div>
            <div style="height: 30px;width: 10px"></div>
            资费:
            <div class="form-group">
                <input type="text" class="form-control">
            </div>
            <div style="height: 30px;width: 10px"></div>
            保险范围:
            <textarea class="form-control" rows="10" cols="50"></textarea>
            <div style="height: 30px;width: 10px"></div>
            <!--以后要以.do的形式传入Servlet跳转页面,现在临时用button代替submit-->
            <!--<button type="submit" class="btn btn-default" onclick="go()">添加</button>-->
            <button type="button" class="btn btn-primary" onclick="go()">添加</button>
            <button type="button" class="btn btn-primary" onclick="go()">返回</button>
        </form>
    </div>
</div>
<script type="text/javascript">
    function go(){
        location.href = "Insurance.jsp"
    }
</script>
</body>
</html>