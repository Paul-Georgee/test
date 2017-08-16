<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保单详情</title>
<link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <style type="text/css">
        .linear{
            background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(rgb(182,231,211)), to(#ffffff));/*谷歌*/
        }
    </style>
</head>
<body>
<div style="background-color: white;width: 70%;height: 500px;margin: auto">
         <div style="text-align: center;height: 70px;width: 100%;margin: auto">
             <h3 >保单维护详细信息</h3><br>
         </div>
         <div style="text-align: center;">
          受益人：${gbInfo.favoree}<br>
         投保人:${gbInfo.client.clientName}	<br>
         电话：${gbInfo.client.tel}<br>
         生日：${gbInfo.client.birthday}<br>
         性别：${ gbInfo.client.gender}<br>
         险种：${gbInfo.insurance.insuName }<br>
         资费：${ gbInfo.insurance.price}元/年<br>
         入保时间：${gbInfo.insureTime }<br>
         </div>
         <div style="text-align: center;">
         保险范围：<br>
         <textarea rows="6" cols="50" >${gbInfo.insurance.content}</textarea><br>
               <a href="/ChinaLife/jsp/section/preserve.jsp" class="btn btn-primary btn-lg active" role="button">返回</a>
                </div>
</div>
</div>
</body>
</html>