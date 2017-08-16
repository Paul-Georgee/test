<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="/ChinaLife/js/jquery-2.1.1.min.js"></script>
    <style type="text/css">
        .linear{
            background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(rgb(182,231,211)), to(#ffffff));/*谷歌*/
        }
        span{
            font-size: 20px;
        }
    </style>
</head>
<body>
<div style="background-color: white;width: 70%;height: 500px;margin: auto">
         <div style="text-align: center;height: 70px;width: 100%;margin: auto">
             <h1 style="text-align: left">修改规章制度</h1><br>
         </div>
         <form action="/ChinaLife/rules/update.do?id=${rules.id}" method="post">
          <div style="margin-left: 50px">
         	<span>规章编号:${rules.id}</span><br><br><br>
         	<span>规章内容:</span><br><br><br>
         	<textarea rows="8" cols="50" name="content">${rules.content}</textarea><br><br><br>
         	<button type="submit" class="btn btn-info">修改</button>
          	<a href="/ChinaLife/jsp/admin/regime.jsp" class="btn btn-primary  active" role="button">返回</a>

            </div>
            </form>
</div>
</body>
</html>