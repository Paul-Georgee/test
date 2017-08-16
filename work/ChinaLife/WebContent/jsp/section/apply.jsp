<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请理赔</title>
<link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
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
             <h3 >申请理赔</h3>
         </div>
         <div style="text-align: center;">
         受益人：${upGbInfo.favoree}<br>
         投保人:${upGbInfo.client.clientName}	<br>
         电话：${upGbInfo.client.tel}<br>
         生日：${upGbInfo.client.birthday}<br>
         性别：${ upGbInfo.client.gender}<br>
         险种：${upGbInfo.insurance.insuName }<br>
         资费：${ upGbInfo.insurance.price}元/年<br>
         入保时间：${upGbInfo.insureTime }<br>
         </div>
         <form action="/ChinaLife/guratee/applyClaim.do" method="post">
         <input type="hidden" name="id" value="${upGbInfo.id }" />
         <div style="text-align: center;">
         
           申请理赔原因：<br>
         <textarea rows="6" cols="50" name="applyReason" ></textarea> <br>
         保险范围：<br>
         <textarea rows="6" cols="50" >${upGbInfo.insurance.content}</textarea><br>
               <input type="submit" value="提交">
                </div>
          </form>
</div>
</body>
</html>