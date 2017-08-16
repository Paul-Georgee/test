<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保单签订</title>
 <link rel="stylesheet" type="text/css" href="/ChinaLife//bootstrap-3.2.0-dist/css/bootstrap.css">
</head>
<body>
<div class="container divWidth">
    <div class="row divWidth">
        <h1 id="title"><strong>新签保单录入</strong></h1>
    </div>
    <div class="row">
        <br><br><br>
        <button class="btn btn-info" id="fa" onclick="addEx()">添加新保单</button>
    </div>
    <div class="row content divWidth divHeight" id="waiDiv">
        <br><br>
        <div class="filePath">
            <form action="/ChinaLife/admin/upload.do" method="post" id="frame" method="post" enctype="multipart/form-data">
                <label>选择excel：</label><input type="file" name="files">
                <br>
                <input type="submit" class="btn btn-info" value="录入保单">
            </form>
        </div>
    </div>
    <div>
    </div>
</div>
<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
<script type="text/javascript">
	var ex="<label>选择excel：</label><input type='file' name='files'><br>";
	var su="<input type='submit' class='btn btn-info' value='录入保单'>";
    function addEx(){
    	ex=ex+"<label>选择excel：</label><input type='file' name='files'><br>";
    	$("#frame").html(ex+su);
    }

</script>
</body>
</html>