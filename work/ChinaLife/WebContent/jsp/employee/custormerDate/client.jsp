<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户资料</title>
<link rel="stylesheet"
	href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
	<script type="text/javascript" src="/ChinaLife/js/jquery-2.1.1.min.js"></script>
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>

<script type="text/javascript"
	src="/ChinaLife/js/bootstrap-paginator.min.js"></script>
<script type="text/javascript">
//分页按钮设置
	var ops = {
		bootstrapMajorVersion : 3, //bootstrap版本
		currentPage : 1, //当前页码
		totalPages : 12, //总页数
		numberOfPages : 5, //页面上最多显示多少页码
		onPageClicked : function(e, ev, type, pag) { // 页码点击事件
			cutPage(pag);
		}
	}
	$(function() {
		cutPage(1);
	})
	//分页显示
	function cutPage(pn) {
		$.post("/ChinaLife/client/findByItem.do", "pageNo=" + pn+
				"&"+$("#f1").serialize() , function(info) {
			//alert(JSON.stringify(info))
			var str = "";
			for (var i = 0; i < info.objects.length; i++) {
				var obj = info.objects[i];
				str += "<tr><td><a href='/ChinaLife/client/show.do?id="
						+ obj.id + "'>" + obj.clientName + "</a></td><td>"
						+ obj.gender + "</td>" + "<td>"
						+ obj.salary + "/月</td><td>" + obj.profession
						+ "</td><td>" + obj.tel
						+ "</td><td><a href='/ChinaLife/client/findById.do?id="
						+ obj.id + "'>修改</a></td></tr>";
			}
			$("#data").html(str);
			if (pn == 1) {
				ops.totalPages = info.pages;
				$("#pageUL").bootstrapPaginator(ops);
			}
		}, "json");
	}
</script>
</head>
<body>


<h1>客户资料</h1><br>

<div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
        
        <!--查询-->
<form id="f1">
        姓名：<input style="width: 20%" type="text"   name="clientName">
        职业：<input style="width: 20%" type="text"   name="profession">
  <button type="button" class="btn btn-success" onclick="cutPage(1)">查询</button>
</form><br>

<table class="table table-striped">

    <thead>
    <tr><th>姓名</th><th>性别</th><th>收入</th><th>职业</th><th>联系方式</th><th>操作</th></tr>
    </thead>
    <tbody id="data"></tbody>
</table><br>
<a href="/ChinaLife/jsp/employee/custormerDate/addClient.jsp" class="btn btn-primary btn-lg active" role="button">添加客户</a>
        
        </div>
        <div class="col-md-1"></div>
</div>
<div style="font-size: 20px; text-align: center">
			<ul id="pageUL"></ul>
		</div>


</body>
</html>