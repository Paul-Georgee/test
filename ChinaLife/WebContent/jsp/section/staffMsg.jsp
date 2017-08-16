<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户详情</title>
<link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
<link rel="stylesheet"
	href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
	<script type="text/javascript" src="/ChinaLife/js/jquery-1.7.min.js"></script>
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>

<style type="text/css">
.linear {
	background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(rgb(182, 231, 211)),
		to(#ffffff)); /*谷歌*/
}
</style>

</head>
<body>
	<div
		style="background-color: white; width: 70%; height: 500px; margin: auto">
		<div
			style="text-align: center; height: 70px; width: 100%; margin: auto">
			<h1 style="text-align: left;">员工信息详情</h1>
			<br>
		</div>
		<div style="float: left; margin-left: 30%">
			<img src="/ChinaLife/images/"${ubInfo.avatar}>
		</div>
		<div style="text-align: left; float: left">
				姓名：${ubInfo.trueName }<br>
			<br> 性别：${ubInfo.gender}<br>
			<br> 电话：${ubInfo.tel}<br>
			<br> 职务：${ubInfo.duty}<br>
			<br> 部门：${ubInfo.department}<br>
			<br>
		</div>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>培训内容</th>
					<th>培训时间</th>
					<th>成绩</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${ubInfo.trains}" var="utb" >
					<tr>
					<td>${utb.content }</td>
					<td>${utb.trainTime }</td>
					<td>${utb.point }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/ChinaLife/jsp/section/showStaff.jsp" class="btn btn-primary btn-lg active"
			role="button">返回</a>

	</div>
</body>
</html>