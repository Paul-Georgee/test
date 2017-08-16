<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>培训详情</title>
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <style type="text/css">
        span{
            font-size: 20px;
        }
    </style>
</head>
<body>
    <div class="row"style="height: 300px;width: 70%;margin: auto;">
        <h1>培训详情</h1>
        <div style="margin: auto;height: 50px;width: 800px;"></div>
        <div class="col-md-1" ></div>
        <div class="col-md-5" >
            <span>培训内容:</span><span>${train.content}</span>
        </div>
        <div class="col-md-6" >
            <span>培训地点:</span><span>${train.location}</span>
        </div>
         <div style="margin: auto;height: 40px;width: 800px;"></div>
         <div class="col-md-1" ></div>
        <div class="col-md-11" >
            <span>培训时间:</span><span>${train.trainTime }</span><span>至</span><span>${train.endTime }</span>
        </div>
        <div style="margin: auto;height: 40px;width: 800px;"></div>
        <div class="col-md-1" ></div>
        <div class="col-md-11" >
            <span>培训状态:</span><span>${train.state }</span>
        </div>
        <div style="margin: auto;height: 40px;width: 800px;"></div>
        <div class="col-md-1" ></div>
        <div class="col-md-11" style="height: 300px">
            <span>培训人员:</span>
           <table class="table table-striped" style="text-align: center">
            <tr>
                <td>姓名</td>
                <td>电话</td>
                <td>部门</td>
                <td>职位</td>
                <td>分数</td>
            </tr>
            <c:forEach var="trainer" items="${train.trains }">
            <tr>
                <td>${trainer.username }</td>
                <td>${trainer.tel }</td>
                <td>${trainer.department }</td>
                <td>${trainer.duty }</td>	
                <td id="point">
                <c:if test="${trainer.point==null }" var="point">
                	<input type="hidden" name="trainId" value="${trainer.id}">
                	<input type="text" name="point">
                </c:if>
                <c:if test="${!point }">${trainer.point }</c:if>
                </td>
            </tr>
			</c:forEach>
        </table>
        	<span id="message" style="padding-right:49%; color:red;"></span>
        </div>
        <div class="col-md-5"><span id="pointMessage" style="color:red;"></span></div>
        <div class="col-md-7">
        <div class="col-md-3">
         <c:if test="${train.state!='已完成' }" var="state">
        	<form action="/ChinaLife/admin/endTrain.do" method="post" onsubmit="return endTrain()">
	        	<input type="hidden" value="${train.id}" name="id">
	           <button type="submit" class="btn btn-primary">结束培训</button>
        	</form>
         </c:if>
        </div>
         <div class="col-md-6">
                  	<button type="button" class="btn btn-primary" onclick="go()">返回</button>
         </div>
        </div>
    </div>
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script type="text/javascript">
        function go(){
            location.href = "/ChinaLife/jsp/admin/train.jsp"
        }
        
		$("input[name='point']").blur(function(){
			var trainId=$(this).prev().attr("value");
			var point=$(this).attr("value");
			re=/(^[1-9]\d{1}|100)$/;
			if(point.match(re)){
				$.post("/ChinaLife/admin/setPoint.do","trainId="+trainId+"&point="+point,
						function(){
					$(this).parent().html(point);
				})
			}else{
					$("#message").html("输入错误")
			}
		});
		
		$("input[name='point']").focus(function(){
			$("#message").html("")
		})
		
		function endTrain(){
			var inputs = $("input[name='point']");
			if(inputs.length==0){
				return true;
			}else{
				$("#pointMessage").html("请给培训的员工打分")
				return false;
			}
		}
    </script>
</body>
</html>