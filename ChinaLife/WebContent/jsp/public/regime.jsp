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
    <style type="text/css">
        .linear{
            background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(rgb(182,231,211)), to(#ffffff));/*谷歌*/
        }
    </style>
</head>
<body>
<div style="background-color: white;width: 70%;height: 500px;margin: auto">
         <div style="text-align: center;height: 70px;width: 100%;margin: auto">
             <h1>人寿保险公司规章制度</h1><br>
         </div>
         <table class="table table-striped">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>内容</th>
               
                </tr>
                </thead >

                <tbody id="data">
                
                </tbody>
            </table>
           <a href="/ChinaLife/index.html" class="btn btn-primary  active" role="button">返回</a>

<script src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
<script type="text/javascript">

$(function(){
	cutPage();
	
})

function cutPage(){
	
	$.post("/ChinaLife/publicRules/showAll.do",function(info){
		var str="";
		for (var i = 0; i < info.length; i++) {
			var obj=info[i];
			str += "<tr><td>"+obj.ruleName+"</td><td>"+obj.content+"</td></tr>"
		}
		$("#data").html(str);
	},"json")

}

</script>

</div>
</body>
</html>