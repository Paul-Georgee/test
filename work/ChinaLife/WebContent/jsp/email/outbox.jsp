<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>发件箱</title>
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>
    <script>
        var ops = {
            bootstrapMajorVersion:3,      //bootstrap版本
            currentPage:1,    //当前页码
            totalPages:12,    //总页数
            numberOfPages:5,  //页面上最多显示多少页码
            onPageClicked:function(e,ev,type,page){   // 页码点击事件
				cutPage(page)
            }
        }
        $(function(){
        	cutPage(1);
        })
        function cutPage(pn){
        	$.post("/ChinaLife/sendEmail/findByItem.do","pageNo="+pn+"&"+$("#f1").serialize(),function(info){
        		var str = "";
        		for(var i = 0; i < info.objects.length; i++){
        			var obj = info.objects[i];
        			str += "<tr><td><a href='/ChinaLife/sendEmail/findById.do?id="+obj.id+"'>"+obj.title+"</a></td><td>"+obj.receivers+"</td><td>"+obj.emailTime+"</td>"+
        			"<td><a href='/ChinaLife/sendEmail/del.do?id="+obj.id+"'>删除</a></td></tr>";
        		}
        		$("#data").html(str);
        		if(pn == 1){
        			ops.totalPages = info.pages;
    				$("#pageUL").bootstrapPaginator(ops);
        		}
        	},"json")
        }
    </script>
</head>
<body>
        <div style="height: 300px;width: 70%;margin: auto">
            <h1>发件箱</h1>
            <div style="margin: auto;height: 50px;width: 800px;"></div>
            <div style="margin: auto;height: 70px;width: 800px;">
                <form class="form-inline" role="form" id="f1">
                    邮件名:
                    <div class="form-group">
                        <input type="text" class="form-control" name="title">
                    </div>
                    <input type=button onclick="cutPage(1)"  class="btn btn-primary" value="搜索">
                </form>
            	</div>
            <div style="margin: auto;height: 230px;width: 800px;">
                <table class="table table-striped" style="text-align: center">
	                <thead>
	                    <tr>
	                        <td>邮件名</td>
	                        <td>收件人</td>
	                        <td>时间</td>
	                        <td>操作</td>
	                    </tr>
	                </thead>
	                <tbody id="data"></tbody>
                </table>
            </div>
            
            <div style="font-size:20px;text-align: center">
				<ul  id="pageUL"></ul>
			</div>
			<a href="/ChinaLife/jsp/email/writeEmail.jsp" class="btn btn-primary active" role="button">写邮件</a>
        </div>
</body>
</html>