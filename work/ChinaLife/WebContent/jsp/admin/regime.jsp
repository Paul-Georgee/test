<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet"
	href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
	<script type="text/javascript" src="/ChinaLife/js/jquery-2.1.1.min.js"></script>
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>

<script type="text/javascript"
	src="/ChinaLife/js/bootstrap-paginator.min.js"></script>
<script type="text/javascript">

	$(function() {
		show();
	})
	//分页显示
	function show() {
		$.post("/ChinaLife/rules/findAll.do", function(info) {
			var str = "";
			for (var i = 0; i < info.length; i++) {
				var obj = info[i];
				str += "<tr><td>"+ obj.id + "</td>" + "<td>"
						+ obj.content + 
						"</td><td><a href='/ChinaLife/rules/findById.do?id="
						+ obj.id + "'>修改</a> </td></tr>";
			}
			$("#data").html(str);
			
		}, "json");
	}
</script>
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
                    <th>操作</th>
                </tr>
                </thead>

                <tbody id="data"></tbody>
            </table>
           <a href="/ChinaLife/jsp/admin/addRegime.jsp" class="btn btn-primary btn-lg active" role="button">添加</a>

</div>
</body>
</html>