<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理员查看本部门员工</title>
<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script type="text/javascript" src="/ChinaLife/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js" ></script>
<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>

<style type="text/css">
.linear {
	background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(rgb(182, 231, 211)),
		to(#ffffff)); /*谷歌*/
}
</style>

<script type="text/javascript">
<%--定义bootsharp分页插件的先关属性--%>
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
		$.post("/ChinaLife/employee/findByItem.do","pageNo="+pn+"&"+$("#f1").serialize(),
				function(info){
			//alert(JSON.stringify(info))
			var str="";
			for(var i=0;i<info.objects.length;i++){
				var userBean=info.objects[i];
				str+="<tr>"+
				"<td>"+userBean.trueName+"</td><td>"+userBean.gender+"</td><td>"+userBean.tel+"</td><td>"
				+userBean.duty+"</td><td><a href='/ChinaLife/employee/findById.do?id="+userBean.id+"'>查看详情</a></td>"
				+"</tr>";	
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
<body class="homepage">


	<div
		style="background-color: white; width: 70%; height: 500px; margin: auto">
		<div
			style="text-align: center; height: 100px; width: 100%; margin: auto">
			<h1 style="text-align: left">员工信息查看</h1>
			<br>
			<form class="form-inline" id="f1">
				<div class="form-group">
					姓名:<input type="text" name="trueName" class="form-control">
				</div>
				<div class="form-group">
					职务:<input type="text" name="duty" class="form-control">
				</div>
				<button type="button" class="btn btn-default" onclick="cut(1)">
					<span class="glyphicon glyphicon-search"></span>查询
				</button>
			</form>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>姓名</th>
					<th>性别</th>
					<th>电话</th>
					<th>职务</th>
					<th>操作</th>
				</tr>
			</thead>

			<tbody id="data">
			</tbody>
		</table>
	</div>
	<div class="row">
	<div class="col-lg-12" style="font-size: 10px; text-align: center">
			<ul id="pageUL"></ul>
	</div>
	</div>
</body>
</html>