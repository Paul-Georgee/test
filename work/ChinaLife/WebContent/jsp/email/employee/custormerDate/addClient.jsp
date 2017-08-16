<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加客户</title>
<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
</head>
<body>

 <h1>添加客户</h1><br>

    <form class="form-inline" role="form" action="" method="post">
        <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-4">
            <div class="form-group">
                姓名： <input type="text" class="form-control"  name="">
            </div><br><br>
            <div class="form-group">
                性别：&nbsp; <input type="radio" name="sex"> 男 &nbsp; <input type="radio" name="sex">女
            </div><br><br>
            <div class="form-group">
                生日：<input type="text" class="form-control"  name="">
            </div><br><br>
            <div class="form-group">
                收入：<input type="text" class="form-control"  neme="">
            </div><br><br>
        </div>
        <div class="col-md-5">

            <div class="form-group">
                职业：<input type="text" class="form-control"  neme="">
            </div><br><br><br>
            <div class="form-group">
                联系方式：<input type="text" class="form-control"  neme="">
            </div><br><br><br>
            <div class="form-group">
                家庭情况：<input type="text" class="form-control"  neme="">
            </div><br><br>
        </div>
        <div class="col-md-1"></div>
        </div><br>

        <div class="row">
            <div class="col-md-5"></div>
            <div class="col-md-7">
                <button type="submit" class="btn btn-default"><a href="client.jsp">添加</a></button>
            </div>
        </div>

    </form><br>
</body>
</html>