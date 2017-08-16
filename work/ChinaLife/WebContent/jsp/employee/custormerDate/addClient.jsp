<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加客户</title>
<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/ChinaLife/js/jquery-2.1.1.min.js"></script>

</head>
<body>

 <h1>添加客户</h1><br>

    <form class="form-inline" role="form" onsubmit="return checkAll()"
    action="/ChinaLife/client/add.do" method="post">
        <div class="row">
        <div class="col-md-2">
        	<input type="hidden" name="user_id" value="${employee.id }">
        </div>
        <div class="col-md-4">
            <div class="form-group">
                姓名： <input type="text" onblur="checkName()" class="form-control"  name="clientName">
                <span style="color: red" id="nameSpan"></span>
            </div><br><br>
            <div class="form-group">
                性别：&nbsp; <input type="radio" checked="checked" name="gender" value="男"> 
                男 &nbsp; <input type="radio" name="gender" value="女">女
            </div><br><br>
            <div class="form-group">
                生日：<input onblur="checkBir()" type="text" class="form-control"  name="birthday">
            <br><span style="color: red" id="birSpan"></span>
            </div><br><br>
            <div class="form-group">
                收入：<input onblur="checkSa()" type="text" class="form-control"  name="salary">
            <br><span style="color: red" id="saSpan"></span>
            </div><br><br>
        </div>
        <div class="col-md-5">

            <div class="form-group">
                职业：<input type="text" onblur="checkZhi()" class="form-control"  name="profession">
          <br><span style="color: red" id="zhiSpan"></span>
            </div><br><br><br>
            <div class="form-group">
                联系方式：<input type="text" onblur="checkTel()" class="form-control"  name="tel">
             <br><span style="color: red" id="telSpan"></span>
            </div><br><br><br>
            <div class="form-group">
                家庭情况：<textarea cols="25" rows="5" onblur="checkFamily()" class="form-control"  name="family"></textarea>
           <br><span style="color: red" id="familySpan"></span>
            </div><br><br>
        </div>
        <div class="col-md-1"></div>
        </div><br>

        <div class="row">
            <div class="col-md-5"></div>
            <div class="col-md-7">
                <button type="submit" class="btn btn-default">添加</button>
            </div>
        </div>
    </form><br>
   <a href="/ChinaLife/jsp/employee/custormerDate/client.jsp" 
   class="btn btn-primary btn-lg active" role="button" style="margin-left: 42%">返回</a>

</body>
<script type="text/javascript">
function checkName(){
	var name = $("input[name='clientName']").val();
	var regex = new RegExp("\\S{1,}");
	if(name.match(regex)){
		$("#nameSpan").html("");
		return true
	}else{
		$("#nameSpan").html("请输入名字");
		return false
	}
}

function checkBir(){
	var bir = $("input[name='birthday']").val();
	var regex = new RegExp("^(19|20)\\d{2}-(1[0-2]|0[1-9])-(0[1-9]|[1-2][0-9]|3[0-1])$");
	if(bir.match(regex)){
		$("#birSpan").html("");
		return true
	}else{
		$("#birSpan").html("请按(xxxx-xx-xx)格式输入");
		return false
	}
}

function checkSa(){
	var sa = $("input[name='salary']").val();
	var regex = new RegExp("[1-9]{1}[0-9]{3,}");
	if(sa.match(regex)){
		$("#saSpan").html("");
		return true
	}else{
		$("#saSpan").html("请输入收入(最少四位)");
		return false
	}
}

function checkZhi(){
	var zhi = $("input[name='profession']").val();
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
	return checkName()&&checkBir()&&checkSa()&&checkZhi()&&checkTel()&&checkFamily();
}
</script>
</html>