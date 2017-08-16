<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发件箱</title>
 <link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <style type="text/css">
        span{
            font-size: 18px;
        }
    </style>
</head>
<body>
	<div style="background-color: white;width: 100%;height: 500px;margin: auto">
    	<div style="height: 60px;width: 400px;margin-left: 100px">
        	<h1 >发件详情</h1><br>
    	</div><br>
        <div style="text-align: left;margin-left: 14%;">
        	<div class="col-md-1" ></div>
        	<div class="col-md-11" >
        		<span>邮件名：</span><span>${ sendEmail.title }</span>
        	</div><br><br><br>
        	<div class="col-md-1" ></div>
        	<div class="col-md-11" >
        		<span>收件人：</span><span>${ sendEmail.receivers }</span>
        	</div><br><br><br>
        	<div class="col-md-1" ></div>
        	<div class="col-md-11" >
        		<span>时间：</span><span>${ sendEmail.emailTime }</span>
        	</div><br><br><br>
        	<c:if test="${ sendEmail.attachment != null }">
        		<div class="col-md-1" ></div>
        		<div class="col-md-11" >
        			<span>附件：</span><a  href="/ChinaLife/sendEmail/wtiteAttach.do?fileName=${ sendEmail.attachment }">下载</a>
        		</div><br><br><br>
        	</c:if>
        	<div class="col-md-1" ></div>
        	<div class="col-md-11" >
        		<span>主要内容：</span><span>${ sendEmail.content }</span>
        	</div>
        	<div style="height: 150px"></div>
        	<div class="col-md-4" ></div>
        	<div class="col-md-8" >
        		<a href="/ChinaLife/jsp/email/outbox.jsp" class="btn btn-primary active" role="button">返回发件箱</a>
        	</div>
        </div>
	</div>
</body>
</html>