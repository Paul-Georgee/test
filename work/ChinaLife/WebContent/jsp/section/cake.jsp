<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>本部门业务员业绩状况</title>
<link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
<link rel="stylesheet"
	href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script type="text/javascript" src="/ChinaLife/assets/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/ChinaLife/js/highcharts.js"></script>


<style type="text/css">
.linear {
	background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(rgb(182, 231, 211)),
		to(#ffffff)); /*谷歌*/
}
</style>
<script type="text/javascript">
    function showPie(sum,arry){
    	var options =  {
    	        title: {//标题
    	            text:'本部门学员成绩分布图'
    	        },
    	        tooltip: {//鼠标移上后提示
    	    	    
    	        },
    	        plotOptions: {//图例
    	            pie: {	
    	                allowPointSelect: true,
    	                cursor: 'pointer',
    	                dataLabels: {
    	                    enabled: true
    	                },
    	                showInLegend: true
    	            }
    	        },
    	        series: [{
    	            type: 'pie'
    	        }]
    	        } 
    	  	
    	options.tooltip.formatter= function (){
			return this.point.name+": " +(this.percentage*sum/100).toFixed(0)+ '人。占比： <b>' + Highcharts.numberFormat(this.percentage, 0) + '%</b>';
		}
		
    	options.series[0].data = arry;
    	$('#container').highcharts(options); 
   	
    }
    
	
   
    
    $(function(){
    	find();
    })
	function find(){
    	$.post("/ChinaLife/statement/findByItem.do",$("#f1").serialize(),function(info){
    		<%--alert(JSON.stringify(info))--%>
    		var sum=0;
    		for(var i=0;i<info.length;i++){
    			var obj=info[i]
    			sum+=obj.count;
    		}
    		
    		var arry=new Array();
			for(var i=0;i<info.length;i++){
				var obj=info[i];
				arry[i]=[obj.username,obj.count]
				
			}
				
			showPie(sum,arry);
				
  		
    	},"json")
    	}

</script>
</head>
<body>
	<div
		style="background-color: white; width: 70%; height: 500px; margin: auto">
		<div
			style="text-align: center; height: 100px; width: 100%; margin: auto">
			<h3>部门业绩查看</h3>
			<br>
			<form class="form-inline" id="f1">
				<div class="form-group">
					起始日期:<input type="text" name="start" class="form-control">
				</div>
				<div class="form-group">
					结束日期:<input type="text" name="end" class="form-control">
				</div>
				<button type="button" class="btn btn-default" onclick="find()">
					<span class="glyphicon glyphicon-search"></span>查询
				</button>
			</form>
		</div>
		<div id="container"
			style="min-width: 400px; height: 400px; margin: 0 auto"></div>
	</div>
	<div class="col-lg-12" style="height:20px"></div>
	 <div class="col-lg-1 col-lg-offset-6">
	 	<a href="/ChinaLife/jsp/section/showStaff.jsp"  class="btn btn-primary btn-lg active">返回</a>
	 </div>
	 
	
</body>
</html>