<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>险种维护</title>
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
        	$.post("/ChinaLife/insurance/findByItem.do","pageNo="+pn+"&"+$("#f1").serialize(),function(info){
        		var str = "";
        		for(var i = 0; i < info.objects.length; i++){
        			var obj = info.objects[i];
        			str += "<tr><td><a href='/ChinaLife/insurance/findById.do?id="+obj.id+"'>"+obj.insuName+"</a></td><td>"+obj.genre+"</td><td>"+obj.price+"</td><td>"+obj.validOrNot+"</td></tr>";
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
        <h1>险种维护</h1>
        <div style="margin: auto;height: 50px;width: 800px;"></div>
        <div style="margin: auto;height: 70px;width: 800px;">
            <form class="form-inline" role="form" id="f1">
                保险名称:
                <div class="form-group">
                    <input type="text" class="form-control" name="insuName">
                </div>
                保险状态:
                <select class="form-control" style="width: 100px" name="state">
               		<option></option>
                    <option>有效</option>
                    <option>无效</option>
                </select>
                <input type=button onclick="cutPage(1)" value="搜索">
            </form>
        </div>
        <div style="margin: auto;height: 230px;width: 800px;">
            <table class="table table-striped" style="text-align: center">
	            <thead>
	                <tr>
	                    <td>险种名称</td>
	                    <td>保险类型</td>
	                    <td>保险资费(年)</td>
	                    <td>保险状态</td>
	                </tr>
	            </thead>
	            <tbody id="data"></tbody>
            </table>
        </div>
        <div style="font-size:20px;text-align: center">
				<ul  id="pageUL"></ul>
		</div>
        <div>
            <button type="button" class="btn btn-primary" onclick="go()">添加险种</button>
        </div>
    </div>
    <script type="text/javascript">
        function go(){
            location.href = "/ChinaLife/jsp/admin/addInsurance.jsp"
        }
    </script>
</body>
</html>