<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>添加培训</title>
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>
    <style type="text/css">
        .alert-people{
            position: absolute;
            left: 50px;
            height: 50px;
            display: none;
        }
    </style>
    <script>
    var array = [];
    var NameArray = [];
        var ops = {
            bootstrapMajorVersion:3,      //bootstrap版本
            currentPage:1,    //当前页码
            totalPages:12,    //总页数
            numberOfPages:5,  //页面上最多显示多少页码
            onPageClicked:function(e,ev,type,page){   // 页码点击事件
				index(page);
            }
        }
        function index(pageNo){
            $.post("/ChinaLife/admin/getEmps.do","pageNo="+pageNo+"&"+$("#search").serialize(),
            		function(data){
            	var str = "";

            	for(var i=0;i<data.objects.length;i++){
            		var emp = data.objects[i];
            		str+="<tr>"+
    	                "<td><input type='checkbox' name='arrayUsersId' onclick='get("+emp.id+")'></td>"+
    	                "<td>"+emp.trueName+"</td>"+
    	                "<td>"+emp.tel+"</td>"+
    	                "<td>"+emp.department+"</td>"+
    	                "<td>"+emp.duty+"</td>"+
    	            "</tr>";
            	}
            	if(pageNo==1){
                	ops.totalPages=data.pages;
                	ops.numberOfPages=data.pages;
                	$("#pageUL").bootstrapPaginator(ops);
            	}
            	$("#data").html(str);
            },"json")
        }
        function choose(){
		var nameArray = [];
		$.each($('input:checkbox'),function(){
            if(this.checked){
            	NameArray.push($(this).parent().next().html())
            }
        })}
        
        function get(number){
        	array.push(number);
        }
        
        function showPeople(){
        	index(1);
            $(".alert-people").fadeIn("slow");
        }
        
        function disappearPeople(){
            $(".alert-people").fadeOut("slow");
            $(".arrayStr").val(array);
            $("#nameArray").html(NameArray.toString());
            array=[];
        }
        
        function go(){
            location.href = "/ChinaLife/jsp/admin/train.jsp"
        }
    </script>
</head>
<body>
    <div class="alert alert-info alert-people" style="width: 600px;height: 400px">
        <form class="form-inline" role="form" id="search">
            姓名:
            <div class="form-group">
                <input type="text" class="form-control" name="trueName">
            </div>
            <button type="button" class="btn btn-default" onclick="index(1)">搜索</button>
        </form>
        <div style="height: 30px;width: 10px"></div>
        <table class="table" style="text-align: center">
        	<thead>
	            <tr>
	                <td>选项</td>
	                <td>姓名</td>
	                <td>电话</td>
	                <td>部门</td>
	                <td>职位</td>
	            </tr>
            </thead>
            <tbody id="data">
            </tbody>
        </table>
        <div style="font-size:20px;text-align: center">
			<ul  id="pageUL"></ul>
		</div>
        <button type="button" class="btn btn-primary" onclick="disappearPeople()">添加</button>
    </div>
    <div style="height: 300px;width: 70%;margin: auto">
        <h1>添加培训</h1>
        <div style="margin: auto;height: 50px;width: 800px;"></div>
        <div style="margin: auto;height: 600px;width: 800px;">
            <form class="form-inline" role="form" action="/ChinaLife/admin/addTrain.do">
                培训内容:
                <div class="form-group">
                    <input type="text" class="form-control" name="content">
                </div>
                <div style="height: 30px;width: 10px"></div>
                培训时间:
                <div class="form-group">
                    <input type="text" class="form-control" name="trainTime">
                </div>
                <div style="height: 30px;width: 10px"></div>
                培训时长:
                <div class="form-group">
                    <input type="text" class="form-control" name="duration">
                </div>
                <div style="height: 30px;width: 10px"></div>
                培训地点:
                <div class="form-group">
                    <input type="text" class="form-control" name="location">
                </div>
                <div style="height: 30px;width: 10px"></div>
                培训人员:
                <div class="form-group">
                <textarea  readonly="readonly" id="na" cols="22" rows="5" name="nameArray" class="form-control"></textarea>
                </div>
                <input type="hidden" name="arrayUsersId"  class="arrayStr">
                <button type="button" class="btn btn-primary" onclick="showPeople()">添加培训人员</button>
                <div style="height: 30px;width: 10px"></div>
                <!--以后要以.do的形式传入Servlet跳转页面,现在临时用button代替submit-->
                <input type="submit" class="btn btn-primary" value="添加">
                <!-- <button type="button" class="btn btn-primary" onclick="go()">添加</button> -->
            </form>
        </div>  
    </div>
</body>
</html>