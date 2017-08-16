<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>添加公告</title>
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
</head>
<body>
<div style="height: 300px;width: 70%;margin: auto">
    <h1>发布新公告</h1>
    <div style="margin: auto;height: 50px;width: 800px;"></div>
    <div style="margin: auto;height: 450px;width: 800px;">
        <form class="form-inline" onsubmit="return checkAll()" role="form" action="/ChinaLife/notice/
        add.do" method="post" enctype="multipart/form-data">
            标题:
            <div class="form-group">
         		 <span style="color: red" id="titleSpan"></span>  <br>
                <input type="text" onblur="checkTitle()" class="form-control" name="title">
                
            </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            公告类型：
            <select class="form-control" style="width: 120px" name="genre">
                    <option value="新闻">新闻</option>
                    <option value="决策">决策</option>
                    <option value="通知">通知</option>
                    <option value="文件">文件</option>
            </select>
            <div style="height: 30px;width: 10px"></div>
            <input type="file" name="fujian">
            <div style="height: 30px;width: 10px"></div>
            内容:
            <textarea onblur="checkCont()" class="form-control" rows="10" 
            cols="50" name="content"></textarea>
           	<br><span style="color: red" id="contSpan"></span>
            <div style="height: 30px;width: 10px"></div>
            <button type="submit" class="btn btn-info">发布</button>
            <a href="/ChinaLife/jsp/admin/notice.jsp" class="btn btn-primary  active" role="button">返回</a>
        </form>
             
        
    </div>
</div>
</body>
<script type="text/javascript">
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

function checkCont(){
	var content = $("textarea[name='content']").val();
	var regex = new RegExp("\\S{1,}");
	if(content.match(regex)){
		$("#contSpan").html("");
		return true
	}else{
		$("#contSpan").html("请输入内容");
		return false
	}
}

function checkAll(){
	return checkTitle()&&checkCont()
}
</script>
</html>