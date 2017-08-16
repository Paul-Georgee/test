<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/video.css" type="text/css" />
<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin-left: 42%; font-size: 18px;">
		${v.videoName}<br>
		主讲人:${v.speaker}<br>
		发布时间:${v.publishTime}
	</div>
	<div style="position: relative;right: 7% ">
		<video width="1200" height="500" src="/ChinaLife/video/${v.filePath}"
			poster="/ChinaLife/images/6.jpg" autoplay="autoplay" preload="none"></video>
	</div><br>
	<a style="margin-left: 44%" href="/ChinaLife/jsp/admin/photo.jsp" class="btn btn-default btn-lg active" role="button">返回</a>
</body>
</html>