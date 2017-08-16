<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人签单</title>
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
		$.post("/ChinaLife/orders/findAll.do", "pageNo=" + pn , function(info) {
			//alert(JSON.stringify(info))
			var str = "";
			for (var i = 0; i < info.objects.length; i++) {
				var obj = info.objects[i];
				str += "<tr><td><a href='/ChinaLife/orders/findById.do?id="
						+ obj.id + "'>" + obj.number + "</a></td><td>"
						+ obj.insurance.insuName + "</td>" + "<td>"
						+ obj.client.clientName + "</td><td>" + obj.insureTime
						+ "</td><td>" + obj.signer
						+ "</td></tr>";
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
	<h1 id="h1">个人签单</h1>

	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<table class="table table-striped">
				<thead>
					<tr>
						<th>保单号</th>
						<th>险种名称</th>
						<th>受保人</th>
						<th>入保时间</th>
						<th>签单人</th>
					</tr>
				</thead>
				<tbody id="data">

				</tbody>

			</table>
		</div>
		<div class="col-md-1"></div>
	</div>
<div style="font-size: 20px; text-align: center">
			<ul id="pageUL"></ul>
		</div>
</body>
</html>