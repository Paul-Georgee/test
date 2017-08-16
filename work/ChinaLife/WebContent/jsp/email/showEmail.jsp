<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收件箱详情</title>
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
             <h1 >邮件详情</h1><br>
         </div><br>
         <div style="text-align: left;margin-left: 14%;">
         	<div class="col-md-1" ></div>
        	<div class="col-md-11" >
        		<span>邮件名：</span><span>${ email.title }</span>
        	</div><br><br>
         	<div class="col-md-1" ></div>
        	<div class="col-md-11" >
        		<span>发件人：</span><span>${ email.email.senderName }</span>
        	</div><br><br>
         	<div class="col-md-1" ></div>
        	<div class="col-md-11" >
        		<span>时间：</span><span>${ email.email.emailTime }</span>
        	</div><br><br>
        	<c:if test="${ email.email.attachment != null }">
        		<div class="col-md-1" ></div>
        		<div class="col-md-11" >
        			<span>附件：</span><a href="/ChinaLife/email/uploadAttach.do?fileName=${ email.email.attachment }">下载</a>
        		</div><br><br>
         	</c:if>
         	<div class="col-md-1" ></div>
        	<div class="col-md-11" >
        		<span>主要内容：</span><span>${ email.email.content }</span>
        	</div>
        	<div style="height: 150px"></div>
        	<div class="col-md-4" ></div>
        	<div class="col-md-8" >
        		 <a href="/ChinaLife/jsp/email/inbox.jsp" class="btn btn-primary btn-lg active" role="button">返回收件箱</a>
        	</div>
         </div>
	</div>
</body>
</html>