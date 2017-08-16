<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>添加公告</title>
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <style type="text/css">
        span{
            font-size: 20px;
        }
    </style>
</head>
<body>
<div style="height: 300px;width: 70%;margin: auto">
    <h1>公告信息</h1>
    <div style="margin: auto;height: 50px;width: 800px;"></div>
    <div style="margin: auto;height: 450px;width: 800px;">
        <form class="form-inline" role="form">
            <span>标题:</span><span>${notice.title }</span>
            <div style="height: 30px;width: 10px"></div>
            
             <span>附件:</span><a href="/ChinaLife/admin/notice/down.do?fileName=${notice.filePath }">${notice.filePath }</a>
             <div style="height: 30px;width: 10px"></div>
            内容:
            <textarea class="form-control" rows="10" cols="50">
            ${notice.content }
            </textarea>
            <div style="height: 30px;width: 10px"></div>
           <a href="/ChinaLife/jsp/admin/notice.jsp" class="btn btn-primary  active" role="button">返回</a>

        </form>
    </div>
</div>

</body>
</html>