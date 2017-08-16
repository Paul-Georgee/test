<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/video.css" type="text/css" />
<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/productlist.js"></script>
<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
<style type="text/css">
	#showDiv{
		margin:1px auto;
		width: 100%;
		height:100%;
	}
	h1{
		position: relative;
		left:5%;
		width:50%;
	}
	#showForm{
		position: relative;
		left:33%;
		width:60%;
	}
</style>
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
		$.post("/ChinaLife/video/findByItem.do", "pageNo=" + pn+
				"&"+$("#f1").serialize() , function(info) {
			var str = "";
			for (var i = 0; i < info.objects.length; i++) {
				var obj = info.objects[i];
				str += "<tr><td>" + obj.speaker
				+ "</td><td><a href='/ChinaLife/video/show.do?id="
						+ obj.id + "'>" + obj.videoName + "</a></td><td>"
						+ obj.permission + "</td>" + "<td>"
						+ obj.publishTime + "</td>";
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
<h1 style="color:black">视频列表</h1>
<div id="showForm">
<form class="form-inline" role="from"  id="f1">
  <div class="form-group">
    <label class="sr-only" for="exampleInputEmail2">主讲人</label>
    <input type="text" class="form-control"  
    name = "speaker" placeholder="请输入主讲人">
  </div>
   <div class="form-group">
    <label class="sr-only" >权限</label>
    <input type="text" class="form-control" 
    name = "permission" placeholder="请输入权限">
  </div>
  <div class="form-group">
    <label class="sr-only" >视频名称</label>
    <input type="text" class="form-control"  
    name = "videoName" placeholder="请输入视频名称">
  </div>
  <button type="button" class="btn btn-default" onclick="cutPage(1)">搜索</button>
</form>
</div>
<table class="table table-striped">
    <thead>
    <tr><th>主讲人</th><th>视频名称</th><th>权限</th><th>发布时间</th><th>操作</th></tr>
    </thead>
    <tbody id="data"></tbody>
</table>
	<div style="font-size:20px;text-align: center;">
		<ul  id="pageUL"></ul>
	</div>
</body>
</html>