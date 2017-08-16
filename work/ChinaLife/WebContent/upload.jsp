<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<body>
       <form enctype="multipart/form-data" 
       method="post" action="/ChinaLife/admin/upload.do">
       		<button id="add">添加表单</button>
       		<input type="file" name="files">
       		<input type="submit" value="提交">
        </form>
<script src="/ChinaLife/assets/js/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
</body>
</html>