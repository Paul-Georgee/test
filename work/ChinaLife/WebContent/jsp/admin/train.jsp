<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>员工培训</title>
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
				index(page);
            }
        }
        $(function(){
        	index(1);
        })
        
        function index(pageNo){
        	$.post("/ChinaLife/admin/getTrains.do","pageNo="+pageNo,function(data){
        		var str = "";
        		for (var i = 0; i < data.objects.length; i++) {
					var train = data.objects[i];
                    str+="<tr>"+
                    "<td><a href='/ChinaLife/admin/train/"+train.id+".do'>"+train.content+"</a></td>"+
                    "<td>"+train.location+"</td>"+
                    "<td>"+train.trainTime+"</td>"+
                    "<td>"+train.state+"</td>"+
                "</tr>";
				}
        		$("#data").html(str);
        		ops.totalPages=data.pages;
        		ops.numberOfPages=data.pages;
        		$("#pageUL").bootstrapPaginator(ops);
        	},"json")}
    </script>
</head>
<body>
        <div style="height: 300px;width: 70%;margin: auto">
            <h1>员工培训</h1>
            <div style="margin: auto;height: 50px;width: 800px;"></div>
            <div style="margin: auto;height: 230px;width: 800px;">
                <table class="table table-striped" style="text-align: center">
                <thead>
                    <tr>
                        <td>培训内容</td>
                        <td>培训地点</td>
                        <td>培训时间</td>
                        <td>培训状态</td>
                    </tr>
				<thead>
				<tbody id="data">
				
				</tbody>
                </table>
            </div>
            <div style="font-size:20px;text-align: center">
				<ul  id="pageUL"></ul>
			</div>
            <div>
                <button type="button" class="btn btn-primary" onclick="go()">添加培训</button>
            </div>
        </div>
<script type="text/javascript">
    function go(){
        location.href = "/ChinaLife/jsp/admin/addTrain.jsp"
    }
</script>
</body>
</html>