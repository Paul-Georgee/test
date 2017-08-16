<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>会议管理</title>
   <link rel="stylesheet"
	href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
	<script type="text/javascript" src="/ChinaLife/js/jquery-2.1.1.min.js"></script>
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>

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
		$.post("/ChinaLife/meeting/findByItem.do", "pageNo=" + pn+
				"&"+$("#f1").serialize() , function(info) {
			//alert(JSON.stringify(info))
			var str = "";
			
			for (var i = 0; i < info.objects.length; i++) {
				var obj = info.objects[i];
				if (obj.state=="已完成") {
					str += "<tr><td><a href='/ChinaLife/meeting/show.do?id="
						+ obj.id + "'>" + obj.title + "</a></td><td>"
						+ obj.huiyiTime + "</td>" + "<td>"
						+ obj.state +"</td><td>" ;
				} else {
					str += "<tr><td><a href='/ChinaLife/meeting/show.do?id="
						+ obj.id + "'>" + obj.title + "</a></td><td>"
						+ obj.huiyiTime + "</td>" + "<td>"
						+ obj.state + " <a href='/ChinaLife/meeting/findById.do?id="
						+ obj.id + "'>修改会议结果</a></td><td>" ;
				}
				
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
        <div style="height: 300px;width: 70%;margin: auto">
            <h1>会议管理</h1>
            <div style="margin: auto;height: 50px;width: 800px;"></div>
            <div style="margin: auto;height: 70px;width: 800px;">
                <form class="form-inline" role="form" id="f1">
                    起始日期:
                    <div class="form-group">
                        <input type="text" class="form-control" name="start">
                    </div>
                    结束日期:
                    <div class="form-group">
                        <input type="text" class="form-control" name="end">
                    </div>
                    会议主题:
                    <div class="form-group">
                        <input type="text" class="form-control" name="title">
                    </div>
                    <button type="button" class="btn btn-default" onclick="cutPage(1)">搜索</button>
                    <input type="reset" class="btn btn-default" value="重置">
                </form>
            	</div>
            <div style="margin: auto;height: 260px;width: 800px;">
                <table class="table table-striped" style="text-align: center">
                    <thead>
                   	 <tr>
                        <th>会议主题</th>
                        <th>会议日期</th>
                        <th>会议状态</th>
                        </tr>
                    </thead>
                	<tbody id="data"></tbody>
                </table>
            </div>
            <div style="font-size:20px;text-align: center;margin-top: 20px">
				<ul  id="pageUL"></ul>
			</div>
            <div>
               <a href="/ChinaLife/jsp/admin/addMeeting.jsp" class="btn btn-default btn-lg active" role="button">添加会议</a>
            </div>
        </div>
</body>
</html>