<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="UTF-8">
<title>添加会议</title>
<link rel="stylesheet"
	href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script type="text/javascript"
	src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
<script type="text/javascript"
	src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>
<style type="text/css">
.alert-people {
	position: absolute;
	left: 50px;
	height: 50px;
	display: none;
}
</style>
<script>
	var array = [];
	var ops = {
		bootstrapMajorVersion : 3, //bootstrap版本
		currentPage : 1, //当前页码
		totalPages : 12, //总页数
		numberOfPages : 5, //页面上最多显示多少页码
		onPageClicked : function(e, ev, type, page) { // 页码点击事件
			cutPage(page)
		}
	}
	function showPeople() {
		cutPage(1);
	}
	function cutPage(pn) {
		$.post("/ChinaLife/admin/getEmps.do", "pageNo=" + pn + "&"
				+ $("#f1").serialize(), function(info) {
			var str = "";
			for (var i = 0; i < info.objects.length; i++) {
				var obj = info.objects[i];
				str += "<tr><td><input type='checkbox' >" + "</td><td>"
						+ obj.trueName + "</td><td>" + obj.tel + "</td>"
						+ "<td>" + obj.department + "</td><td>" + obj.duty
						+ "</td></tr>";
			}
			$("#data").html(str);
			if (pn == 1) {
				ops.totalPages = info.pages;
				$("#pageUL").bootstrapPaginator(ops);
			}
		}, "json")
	}
	function getNames(name) {
		$.each($('input:checkbox'), function() {
			if (this.checked) {
				array.push($(this).parent().next().html())
			}
		})
		$("#na").html(array.toString())
	}
	
	function f(){
		$("#na").html("")
		array = []
	}
	
	function checkTitle(){
		var title = $("input[name='title']").val();
		var regex = new RegExp("\\S{1,}");
		if(title.match(regex)){
			$("#titleSpan").html("");
			return true
		}else{
			$("#titleSpan").html("请输入标题");
			return false
		}
	}

	function checkLocation(){
		var location = $("input[name='location']").val();
		var regex = new RegExp("\\S{1,}");
		if(location.match(regex)){
			$("#locationSpan").html("");
			return true
		}else{
			$("#locationSpan").html("请输入会议地点");
			return false
		}
	}
	
	function checkDate(){
		var date = $("input[name='huiyiTime']").val();
		var regex = new RegExp("^(19|20)\\d{2}-(1[0-2]|0[1-9])-(0[1-9]|[1-2][0-9]|3[0-1])$");
		if(date.match(regex)){
			$("#dateSpan").html("");
			return true
		}else{
			$("#dateSpan").html("请按(xxxx-xx-xx)格式输入");
			return false
		}
	}
	
	function checkConf(){
		var conferee = $("#na").val();
		var regex = new RegExp("\\S{1,}");
		if(conferee.match(regex)){
			$("#confereeSpan").html("");
			return true
		}else{
			$("#confereeSpan").html("请选择与会人员");
			return false
		}
	}
	
	function checkCont(){
		var content = $("textarea[name='content']").val();
		var regex = new RegExp("\\S{1,}");
		if(content.match(regex)){
			$("#contentSpan").html("");
			return true
		}else{
			$("#contentSpan").html("请输入会议内容");
			return false
		}
	}
	
	function checkAll(){
		return checkTitle()&&checkLocation()&&checkDate()&&checkConf()&&checkCont();
	}
</script>

</head>
<body>
	<div style="height: 300px; width: 70%; margin-left: 30%">
		<h1>添加会议</h1>
		<div style="margin: auto; height: 50px; width: 800px;"></div>
		<div style="margin: auto; height: 600px; width: 800px;">
			<form class="form-inline" role="form" action="/ChinaLife/meeting/add.do" 
			method="post" onsubmit="return checkAll()">

				会议主题:
				<div class="form-group">
					<input type="text" class="form-control" onblur="checkTitle()" name="title">
					<br><span style="color: red"id="titleSpan"></span>
				</div>
				<div style="height: 30px; width: 10px"></div>
				会议地点:
				<div class="form-group">
					<input type="text" onblur="checkLocation()" class="form-control" name="location">
					<br><span style="color: red"id="locationSpan"></span>
				</div>
				<div style="height: 30px; width: 10px"></div>
				会议日期:
				<div class="form-group">
					<input type="text" onblur="checkDate()" class="form-control" name="huiyiTime">
					<br><span style="color: red"id="dateSpan"></span>
				</div>
				<div style="height: 30px; width: 10px"></div>
				与会人员:
				<div class="form-group">
					<textarea  readonly="readonly" id="na" cols="22" rows="5" name="conferee" class="form-control"></textarea>
					<br><span style="color: red"id="confereeSpan"></span>
				</div>
				<div style="height: 30px; width: 10px"></div>
				会议内容:
				<div class="form-group">
					<textarea onblur="checkCont()" cols="22" rows="5" class="form-control" name="content"></textarea>
					<br><span style="color: red"id="contentSpan"></span>
				</div>
				<div style="height: 30px; width: 10px"></div>
				<!--以后要以.do的形式传入Servlet跳转页面,现在临时用button代替submit-->
				<!--<button type="submit" class="btn btn-default" onclick="go()">添加</button>-->
				<button type="submit" class="btn btn-primary" >添加</button>
				<a href="/ChinaLife/jsp/admin/meeting.jsp" class="btn btn-default  active" role="button">返回</a>
			</form>
			<button style="position: relative; left: 36%; bottom: 260px;"
				class="btn btn-primary" data-toggle="modal" data-target="#myModal"
				onclick="showPeople()">添加与会人员</button><button style="position: relative; left: 36%; bottom: 260px;" type="button" onclick="f()"  class="btn btn-warning">重选</button>
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">选择人员</h4>
						</div>
						<div class="modal-body">
							<form class="form-inline" role="form" id="f1">
								姓名:
								<div class="form-group">
									<input type="text" class="form-control" name="trueName">
								</div>
								<button type="button" class="btn btn-default"
									onclick="cutPage(1)">搜索</button>
							</form>
							<div style="height: 30px; width: 10px"></div>
							<table class="table table-striped" style="text-align: center">
								<thead>
									<tr>
										<td>选项</td>
										<td>姓名</td>
										<td>电话</td>
										<td>部门</td>
										<td>职位</td>
									</tr>
								</thead>
								<tbody id="data"></tbody>
							</table>
							<div style="font-size: 20px; text-align: center">
								<ul id="pageUL"></ul>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="button" data-dismiss="modal" onclick="getNames()"
								class="btn btn-primary">确定</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
		</div>
	</div>
	
</body>

</html>