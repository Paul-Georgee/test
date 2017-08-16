<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息</title>
 <link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>
    <script>
        var ops = {
            bootstrapMajorVersion:3,      //bootstrap版本
            currentPage:1,    //当前页码
            totalPages:12,    //总页数
            numberOfPages:4,  //页面上最多显示多少页码
            onPageClicked:function(e,ev,type,page){   // 页码点击事件
				index(page);
            }
        }
        $(function(){
        	getdeparts();
        	index(1);

        })
        
        function getdeparts(){
        	$.post("/ChinaLife/public/departments.do",function(data){
        		var str = "<option value='0'>所有</option>";
        		for (var i = 0; i < data.length; i++) {
        			str+="<option value='"+data[i].id+"'>"+data[i].departName+"</option>";
				}
        		$("#departments").append(str);
        	},"json")
        };
        
        
        function index(pageNo){
        	$.post("/ChinaLife/public/contacts.do","pageNo="+pageNo+"&"+
        			$("#search").serialize(),
        			function(data){
        		var str = "";
        		for (var i = 0; i < data.objects.length; i++) {
					var contact = data.objects[i];
                    str+="<tr>"+
                    "<td>"+contact.trueName+"</td>"+
                    "<td>"+contact.gender+"</td>"+
                    "<td>"+contact.tel+"</td>"+
                    "<td>"+contact.duty+"</td>"+
                    "<td>"+contact.department+"</td></tr>";
				}
        		$("#data").html(str);

        		if(pageNo==1){
            		ops.totalPages=data.pages;
            		ops.numberOfPages=data.pages;
            		$("#pageUL").bootstrapPaginator(ops);
        		}
        	},"json")}
    </script>
    
    
    <style type="text/css">
        .linear{
            background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(rgb(182,231,211)), to(#ffffff));/*谷歌*/
        }

    </style>
</head>
<body class="homepage">


     <div style="background-color: white;width: 70%;height: 500px;margin: auto">
         <div style="text-align: center;height: 100px;width: 100%;margin: auto">
             <h1 style="text-align: left;">员工信息查看</h1><br>
             <form class="form-inline"  id="search">
                 <div class="form-group">
                     姓名:<input type="text" class="form-control" name="trueName">
                 </div>
                 <div class="form-group">
                     职务:<input type="text" class="form-control" name="duty">
                 </div>
               	 <div class="form-group">
                     部门:
                     <select name="departmentId" id="departments" class="form-control">
                     
                     </select>
                 </div>
                 <button type="button" class="btn btn-default" onclick="index(1)"><span class="glyphicon glyphicon-search"></span>查询</button>
             </form>

         </div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>电话</th>
                    <th>职务</th>
                    <th>部门</th>
                </tr>
                </thead>
                <tbody id="data">

                </tbody>
            </table>
        </div>
            <div style="font-size:20px;text-align: center">
				<ul  id="pageUL"></ul>
			</div>
</body>
</html>