<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除用户</title>
<link rel="stylesheet"
	href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script type="text/javascript"
	src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
<script type="text/javascript"
	src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
<script type="text/javascript"
	src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>
<script type="text/javascript">
	var ops = {
		bootstrapMajorVersion : 3, //bootstrap版本
		currentPage : 1, //当前页码
		numberOfPages : 6, //页面上最多显示多少页码
		onPageClicked : function(e, ev, type, page) { // 页码点击事件
			cut(page)
		}
	}

	var opss = {
		bootstrapMajorVersion : 3, //bootstrap版本
		currentPage : 1, //当前页码
		numberOfPages : 6, //页面上最多显示多少页码
		onPageClicked : function(e, ev, type, page) { // 页码点击事件
			find(page)
		}
	}

	$(function() {
		cut(1)
	})
	function cut(pn) {
		$
				.post(
						"/ChinaLife/emploee/findGuranteeItemById.do",
						"pageNo=" + pn,
						function(info) {
<%--alert(JSON.stringify(info))--%>
	var str = ""
							for (var i = 0; i < info.objects.length; i++) {
								var obj = info.objects[i]
								str += "<tr>"
										+ "<td><input type='checkbox' name='gurantees' value='"+obj.id+"'></td><td>"
										+ obj.number + "</td><td>"
										+ obj.client.clientName + "</td><td>"
										+ obj.insurance.insuName + "</td>"
										+ "</tr>"
							}

							$("#data").html(str)
<%--动态实现每一页显示的数相同--%>
	if (pn == 1) {
								ops.totalPages = info.pages;
								$("#pageUL").bootstrapPaginator(ops);
							}

						}, "json")
	}

	function find(pns) {
		$
				.post(
						"/ChinaLife/emploee/findUserInDepartment.do",
						"pageNo=" + pns + "&" + $("#f1").serialize(),
						function(infos) {
<%-- alert(JSON.stringify(infos))--%>
	var strs = ""
							for (var i = 0; i < infos.objects.length; i++) {
								var obj = infos.objects[i]
								strs += "<tr>"
										+ "<td><input type='radio' name='optionsRadios' value='"+obj.id+"'></td><td>"
										+ obj.trueName + "</td><td>"
										+ obj.gender + "</td><td>" + obj.tel
										+ "</td><td>" + obj.role + "</td><td>"

										+ "</tr>"
							}
							$("#datas").html(strs)

							if (pns == 1) {
								opss.totalPages = infos.pages;
								$("#pageULs").bootstrapPaginator(opss);
							}
						}, "json")
	}
<%-- 选择联系人点击事件--%>
	$("#findUserId").live('click', function() {
		var userId = document.getElementsByName("optionsRadios");

		for (var i = 0; i < userId.length; i++) {
			if (userId[i].checked == true) {
				document.getElementById("forUserId").value = userId[i].value;

			}
		}
	})
	
	<%--表单提交时判断是否为空 防治置空--%>
	function check(){
		var uuid=document.getElementById("forUserId").value;
		var bool=document.getElementsByName("gurantees");
		var ssh=0;
		for (var i = 0; i < bool.length; i++) {
			if (bool[i].checked == true) {
				ssh = 1;
			}
		}
		
		
		if(uuid.length!=0&&ssh==1){
			$("#showMsg").html("");
			return true;
		}else{
			$("#showMsg").html("请选择保单与跟进人后进行操作");
			return false;
				
		}
		
	}
</script>
</head>
<body>

	<h1>修改跟踪人</h1>

	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<form action="/ChinaLife/emploee/changeTrack.do" method="post"
				class="form-inline" role="form" onsubmit="return check() ">
				<input type="hidden" id="forUserId" name="id">
				<table class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>保单号</th>
							<th>投保人</th>
							<th>跟保人</th>
						</tr>
					</thead>
					<tbody id="data">

					</tbody>
				</table>
				<div class="col-md-4">
				<button type="submit" class="btn btn-default">确定</button>
				<button type="button" class="btn btn-default" data-toggle="modal"
		data-target="#myModal" onclick="find(1)">选择移交人</button>
				</div>
				<span id="showMsg" style="color:red"></span>
			</form>
		</div>
		<div class="col-md-1"></div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">同部门其他业务员</h4>
				</div>
				<div class="modal-body">

					<form class="form-inline" role="form" id="f1">
						<div class="form-group">
							姓名： <input type="text" class="form-control" name="trueName">
						</div>
						<button type="button" class="btn btn-default" onclick="find(1)">查询</button>
					</form>
					<br>

					<table class="table table-striped">
						<thead>
							<tr>
								<th></th>
								<th>姓名</th>
								<th>性别</th>
								<th>电话号码</th>
								<th>职务</th>
							</tr>
						</thead>
						<tbody id="datas">

						</tbody>
					</table>

					<button type="button" id="findUserId" class="btn btn-default"
						data-dismiss="modal">确定</button>
					
					<div class="row">
						<div class="col-lg-12" style="font-size: 10px; text-align: center">
							<ul id="pageULs"></ul>
						</div>
					</div>
				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->



	<div class="row">
		<div class="col-lg-12" style="font-size: 10px; text-align: center">
			<ul id="pageUL"></ul>
		</div>
	</div>



</body>
</html>