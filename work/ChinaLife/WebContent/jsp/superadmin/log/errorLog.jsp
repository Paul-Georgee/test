<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误日志</title>
<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script type="text/javascript" src="/ChinaLife/js/jquery-1.7.min.js"></script>
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>
<script type="text/javascript">

var ops = {
        bootstrapMajorVersion:3,      //bootstrap版本
        currentPage:1,    //当前页码
        totalPages:12,    //总页数
        numberOfPages:5,  //页面上最多显示多少页码
        onPageClicked:function(e,ev,type,page){   // 页码点击事件
        cutPage(page);
        }
    }

$(function(){
	cutPage(1);
})

function cutPage(pn){
	
	$.post("/ChinaLife/logs/findAll.do","pageNo="+pn+"&"+$("#f1").serialize(),function(info){
		//alert(JSON.stringify(info));
		var str="";
		for (var i = 0; i < info.objects.length; i++) {
			var obj=info.objects[i];
			str +="<tr><td>"+obj.errorDate+"</td><td>"+obj.content+"</td></tr>"
		}
		$("#data").html(str);
		
		if(pn==1){
			ops.totalPages=info.pages;
				
			$("#cutPageDiv").bootstrapPaginator(ops);
		}
		
	},"json");
	
}

</script>

</head>
<body>
<h1>错误日志</h1><br>

<div class="row">
      
        <div class="col-md-1"></div>
        <div class="col-md-10">
        
<form class="form-inline" role="form" id="f1" >
<div class="form-group">
    开始时间： <input type="text" class="form-control"  name="start">
</div>
<div class="form-group">
    结束时间：<input type="text" class="form-control"  name="end">
</div>
<button type="button" class="btn btn-default" onclick="cutPage(1)">查询</button>
</form><br>

<table class="table table-striped">

    <thead>
        <tr><th>时间</th><th>异常信息</th></tr>
    </thead>
    <tbody id="data">
       
    </tbody>
    
</table>
        <div style="font-size:20px;text-align: center" ></div>
        	<ul id="cutPageDiv"></ul>
        </div>
        <div class="col-md-1"></div>
</div>


</body>
</html>