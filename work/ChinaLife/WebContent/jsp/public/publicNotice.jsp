<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>公告</title>
   <link rel="stylesheet"
	href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
	<script type="text/javascript" src="/ChinaLife/js/jquery-2.1.1.min.js"></script>
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>

<script type="text/javascript"
	src="/ChinaLife/js/bootstrap-paginator.min.js"></script>
<script type="text/javascript">

	$(function() {
		show();
	})
	//分页显示
	function show() {
		$.post("/ChinaLife/notice/findAll.do", function(info) {
			
			var str = "";
			for (var i = 0; i < info.length; i++) {
				var obj = info[i];
				str += "<tr><td>"+ obj.title + "</td>" + "<td>"
						+ obj.noticeTime + 
						"</td><td><a href='/ChinaLife/notice/show.do?id="
						+ obj.id + "'>查看</a></td></tr>";
			}
			$("#data").html(str);
			
		}, "json");
	}
</script>
</head>
<body>
    <div style="height: 300px;width: 70%;margin: auto">
        <h1>公告</h1><br><br>
        <div style="margin: auto;height: 230px;width: 800px;">
            <table class="table table-striped" >
                <thead>
               		<tr>
                    <th>公告标题</th>
                    <th>发布时间</th>
                    <th>操作</th>
                    </tr>
                </thead>
                <tbody id="data"></tbody>
            </table>
        </div>
    </div>
</body>
</html>