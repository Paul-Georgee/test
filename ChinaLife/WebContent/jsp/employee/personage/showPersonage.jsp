<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
<title>保单详情</title>
</head>
<body>
<h1>签单详情</h1>

<div class="row">
        
        <div class="col-md-1"></div>
        <div class="col-md-10">
        
        <div class="row">
        <div class="col-md-6">
        
        姓名：${GB.client.clientName}<br><br>
        电话：${GB.client.tel}<br><br>
        性别：${GB.client.gender}
        </div>
        <div class="col-md-6">
        险种：${GB.insurance.insuName}<br><br>
        资费：${GB.insurance.price}/年<br><br>
        入保时间：${GB.insureTime}<br><br>
        </div>
		</div>
		<br>
		保险范围：<br>
		<textarea rows="20" cols="100">
			${GB.insurance.content}
		</textarea><br><br>
		
		<div class="row">
        <div class="col-md-6">
        甲方：中国人寿保险有限公司<br><br>
        签字：${GB.signer}<br><br>
        </div>
        <div class="col-md-6">
        乙方：${GB.client.clientName}<br><br>
        时间：${GB.insureTime}<br><br>
        </div>
		</div>
		<div class="row">
        <div class="col-md-5"></div>
        <div class="col-md-7">
           <a href="/ChinaLife/jsp/employee/personage/personage.jsp" class="btn btn-primary  active" role="button">返回</a>
        </div>
    </div>
        
        </div>
        <div class="col-md-1"></div>
</div>




</body>
</html>