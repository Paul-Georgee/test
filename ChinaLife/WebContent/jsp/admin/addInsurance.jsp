<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>添加险种</title>
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
</head>
<body>
<div style="height: 300px;width: 70%;margin: auto">
    <h1>添加险种信息</h1>
    <div style="margin: auto;height: 50px;width: 800px;"></div>
    <div style="margin: auto;height: 600px;width: 800px;">
        <form class="form-inline" role="form" action="/ChinaLife/insurance/add.do" method="post" onsubmit="return checkAll()">
            险种名称:
            <div class="form-group">
                <input type="text" class="form-control" name="insuName" onblur="checkName()" id="insuranceName">
            </div><span id="checkInsuranceName" style="color:red"></span>
            <div style="height: 30px;width: 10px"></div>
            险种资费:
            <div class="form-group">
                <input type="text" class="form-control" name="price" onblur="checkPrice()" id="insurancePrice">
            </div><span id="checkInsurancePrice" style="color:red"></span>
            <div style="height: 30px;width: 10px"></div>
            险种类别:
            <div class="form-group">
                <input type="text" class="form-control" name="genre" onblur="checkGenre()" id="insuranceGenre">
            </div><span id="checkInsuranceGenre" style="color:red"></span>
            <div style="height: 30px;width: 10px"></div>
            保险内容:
            <textarea class="form-control" rows="10" cols="50" name="content" onblur="checkContent()" id="insuranceContent"></textarea>
            <span id="checkInsuranceContent" style="color:red"></span>
            <div style="height: 30px;width: 10px"></div>
            <!--以后要以.do的形式传入Servlet跳转页面,现在临时用button代替submit-->
            <!--<button type="submit" class="btn btn-default" onclick="go()">添加</button>-->
            <button type="submit" class="btn btn-primary" >添加</button>
            <button type="button" class="btn btn-primary" onclick="go()">返回</button>
        </form>
    </div>
</div>
<script type="text/javascript">
    function go(){
        location.href = "/ChinaLife/jsp/admin/Insurance.jsp"
    }
    function checkName(){
    	var insuranceName = $("#insuranceName").val();
    	if(insuranceName == ""){
    		$("#checkInsuranceName").text("不能为空！");
    		return false;
    	}else{
    		if(/\s/.test(insuranceName)){
    			$("#checkInsuranceName").text("不能有空格！")
    			return false
    		}else{
    			$("#checkInsuranceName").text("");
        		return true;
    		}
    	}
    }
    function checkPrice(){
    	var insurancePrice = $("#insurancePrice").val();
    	var reg = /^[0-9]*$/;
    	if(insurancePrice == ""){
    		$("#checkInsurancePrice").text("不能为空！");
    		return false;
    	}else{
    		if(/\s/.test(insurancePrice)){
    			$("#checkInsurancePrice").text("不能有空格！")
    			return false
    		}else{
    			if(!reg.test(insurancePrice)){
    				$("#checkInsurancePrice").text("只能为数字！")
        			return false
    			}else{
    				$("#checkInsurancePrice").text("");
            		return true;
    			}
    		}
    	}
    }
    function checkGenre(){
    	var insuranceGenre = $("#insuranceGenre").val();
    	if(insuranceGenre == ""){
    		$("#checkInsuranceGenre").text("不能为空！");
    		return false;
    	}else{
    		if(/\s/.test(insuranceGenre)){
    			$("#checkInsuranceGenre").text("不能有空格！")
    			return false
    		}else{
    			$("#checkInsuranceGenre").text("");
        		return true;
    		}
    	}
    }
    function checkContent(){
    	var insuranceContent = $("#insuranceContent").val();
    	if(insuranceContent == ""){
    		$("#checkInsuranceContent").text("不能为空！");
    		return false;
    	}else{
    		$("#checkInsuranceContent").text("");
    		return true;
    	}
    }
    function checkAll(){
    	return checkName()&&checkPrice()&&checkGenre()&&checkContent();
    }
</script>
</body>
</html>