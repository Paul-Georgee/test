<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link rel="stylesheet"
	href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>
<script type="text/javascript">
	var ops = {
        bootstrapMajorVersion:3,      //bootstrap版本
        currentPage:1,    //当前页码
        numberOfPages:6,  //页面上最多显示多少页码
        onPageClicked:function(e,ev,type,page){   // 页码点击事件
			cut(page)
        }
    }

	$(function(){
		cut(1);
	})
	function cut(pn){
		$.post("/ChinaLife/emploee/findByItem.do","pageNo="+pn+"&"+$("#f1").serialize(),function(info){
			<%--alert(JSON.stringify(info))--%>
			var str="";
			for(var i=0;i<info.objects.length;i++){
				var obj=info.objects[i];
				str+="<tr>"+
					"<td>"+obj.trueName+"</td><td>"+obj.gender+"</td><td>"+obj.duty+"</td><td>"+obj.department+"</td><td>"+
					obj.tel+"</td><td>"+obj.state+"</td><td>"+"<a href='/ChinaLife/emploee/findUserById.do?id="+obj.id+"'>修改用户信息</a>"
					+" <a href='/ChinaLife/emploee/findInsuranceById.do?id="+obj.id+"'>删除用户</a>"
				+"</td></tr>";
			}
			
			$("#data").html(str);
			
			<%--动态实现每一页显示的数相同--%>
			if(pn == 1){
				ops.totalPages = info.pages;
				$("#pageUL").bootstrapPaginator(ops);
			}
			
		},"json")
	
	}
</script>
</head>
<body>

	<h1>用户管理</h1>
	<br>

	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">

			<form class="form-inline" role="form" id="f1">
				<div class="form-group">
					姓名： <input type="text" name="trueName" class="form-control" name="">
				</div>
				<div class="form-group">
					职务：<input type="text" name="duty" class="form-control" name="">
				</div>
				<button type="button" class="btn btn-default" onclick="cut(1)">查询</button>
			</form>
			<br>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>姓名</th>
						<th>性别</th>
						<th>职务</th>
						<th>所在部门</th>
						<th>联系方式</th>
						<th>在职状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="data">
					
				</tbody>
			</table>
			<button type="button" class="btn btn-default">
				<a href='/ChinaLife/emploee/findDepartName.do'>添加用户</a>
			</button>
		</div>
		<div class="col-md-1"></div>

	</div>

	<div class="row">
		<div class="col-lg-12" style="font-size: 10px; text-align: center">
			<ul id="pageUL"></ul>
		</div>
	</div>

</body>
</html>