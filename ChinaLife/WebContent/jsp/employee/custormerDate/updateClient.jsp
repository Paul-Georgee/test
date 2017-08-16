<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>
<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script type="text/javascript" src="/ChinaLife/js/jquery-2.1.1.min.js"></script>
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
</head>
<body>
<h1>修改客户信息</h1><br>

<form class="form-inline"  action="/ChinaLife/client/update.do?id=${client.id}"
onsubmit="return checkAll()" method="post">
        <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-4">
           
                姓名： ${client.clientName} <br><br>
            
                性别： ${client.gender}<br><br>
           
                生日： ${client.birthday}<br><br><br>
                
            <div class="form-group">
                收入：<input id="shou" type="text" class="form-control" 
                 onblur="checkShou()" value=" ${client.salary}" name="salary"><br>
          	<span style="color: red" id="shouSpan"></span>
            </div><br><br>
        </div>
        <div class="col-md-5">

            <div class="form-group">
                职业：<input id="zhi" type="text" class="form-control"
                 value=" ${client.profession}" onblur="checkZhi()"  name="profession">
            	<span style="color: red" id="zhiSpan"></span>
            </div><br><br><br>
            <div class="form-group">
                联系方式：<input type="text" class="form-control"  
                value="${client.tel}" onblur="checkTel()"  name="tel">
                <span style="color: red" id="telSpan"></span>
            </div><br><br><br>家庭情况：
            <div class="form-group">
                <textarea rows="5" cols="40"   name="family"
                onblur="checkFamily()">${client.family}</textarea><br>
                <span style="color: red" id="familySpan"></span>
            </div><br><br>
        </div>
        <div class="col-md-1"></div>
        </div><br>

        <div class="row">
            <div class="col-md-5"></div>
            <div class="col-md-7">
                <button type="submit" class="btn btn-default">修改</button>
            </div>
        </div>
    </form><br>
</body>
<script type="text/javascript">
	function checkShou(){
		var shou = $("#shou").val();
		var regex = new RegExp("[1-9]{1}[0-9]{3,}");
		if(shou.match(regex)){
			$("#shouSpan").html("")
			return true
		}else{
			$("#shouSpan").html("请输入正确的数字(最少四位数)");
			return false
		}
	}
	
	function checkZhi(){
		var zhi = $("#zhi").val();
		var regex = new RegExp("\\S{1,}");
		if(zhi.match(regex)){
			$("#zhiSpan").html("");
			return true
		}else{
			$("#zhiSpan").html("请输入职业");
			return false
		}
	}
	
	function checkTel(){
		var tel = $("input[name='tel']").val();
		var regex = new RegExp("^[1][3|5|7|8]{1}[1-9]{1}[0-9]{8}$");
		if(tel.match(regex)){
			$("#telSpan").html("");
			return true
		}else{
			$("#telSpan").html("请输入正确的电话号码");
			return false
		}
	}
	
	function checkFamily(){
		var f = $("textarea[name='family']").val();
		var regex = new RegExp("\\S{1,}");
		if(f.match(regex)){
			$("#familySpan").html("");
			return true
		}else{
			$("#familySpan").html("请输入家庭情况");
			return false
		}
	}
	
	function checkAll(){
		return checkShou()&&checkZhi()&&checkTel()&&checkFamily();
	}
</script>
</html>