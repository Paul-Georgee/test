<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>部门管理</title>
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>
    <script>
        $(function(){
        	showAll();
        })
        function showAll(){
        	$.post("/ChinaLife/department/findAll.do",function(info){
        		var str = "";
        		for(var i = 0; i < info.length; i++){
        			var obj = info[i];
        			str += "<tr><td>"+obj.departName+"</td><td>"+obj.leader+"</td><td>"+obj.count+"</td>"+
        			"<td><a href='/ChinaLife/department/findById.do?id="+obj.id+"' class='btn btn-primary btn-sm ' role='button'>修改</a>&nbsp;&nbsp;&nbsp;"+
        			"<button class='btn btn-danger btn-sm deleteDepart' data-toggle='modal' data-target='#myModal' value='"+obj.id+"'>删除</button></td></tr>";
        		}
        		
        		$("#data").html(str);
        	},"json")
        }
        
    </script>
</head>
<body>
	 <div style="height: 300px;width: 70%;margin: auto">
            <h1>部门管理</h1>
            <div style="margin: auto;height: 50px;width: 800px;">
            	<div style="margin: auto;width:260px">
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					        <h4 class="modal-title" id="myModalLabel">温馨提示：</h4>
					      </div>
					      <div class="modal-body" style="text-align: center;">
					      	<span style="color: red;font-size: 16px;line-height: 80px" id="Prompt"></span>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
					      </div>
					    </div><!-- /.modal-content -->
					  </div><!-- /.modal-dialog -->
					</div>
            	</div>
            </div>
            <div style="margin: auto;width: 800px;">
            	
                <table class="table table-striped" style="text-align: center">
	                <thead>
	                    <tr>
	                        <td>部门</td>
	                        <td>部门负责人</td>
	                        <td>部门人数</td>
	                        <td>操作</td>
	                    </tr>
	                </thead>
	                <tbody id="data"></tbody>
                </table>
            </div>
            
				<button class="btn btn-primary add" data-toggle="modal" data-target="#yourModal">添加</button>
				<!-- Modal -->
				<form class="form-inline" role="form" action="/ChinaLife/department/add.do" method="post" onsubmit="return checkAll()">
				<div class="modal fade" id="yourModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				        <h4 class="modal-title" id="myModalLabel">添加部门</h4>
				      </div>
				      <div class="modal-body" style="text-align: center">
				      		<span id="checkDepartmentName" style="color:red"></span>
				      		<br>
				            部门名称:
				            <div class="form-group">
				                <input type="text" class="form-control" name="departName" onblur="checkName()" id="departmentName">
				            </div>
				            <br><br>
				            <span id="checkDepartmentDescription" style="color:red"></span>
				            <br>
				            部门描述:
				            <div class="form-group">
				                <input type="text" class="form-control" name="departDescription" onblur="checkDescription()" id="departmentDescription">
				            </div>
				            <div style="height: 30px;width: 10px"></div>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				        <button type="submit" class="btn btn-primary">添加</button>
				      </div>
				    </div><!-- /.modal-content -->
				  </div><!-- /.modal-dialog -->
				</div>
            </form>
        </div>

<script type="text/javascript">
    function go(){
        location.href = "department.jsp"
    }
    $(".deleteDepart").live("click",function(){
    	var departmentId = $(this).val();
    	$.post("/ChinaLife/department/del.do","departmentId="+departmentId,function(info){
    		if(info == 1){
    			$("#Prompt").html("部门还有人不能删除！！！");
    		}else{
    			$("#Prompt").html("删除成功！！！");
    			window.location = "/ChinaLife/jsp/admin/department.jsp";
    		}
    	})
    })
    function checkName(){
    	var departmentName = $("#departmentName").val();
    	if(departmentName == ""){
    		$("#checkDepartmentName").text("不能为空！");
    		return false;
    	}else{
    		if(/\s/.test(departmentName)){
    			$("#checkDepartmentName").text("不能有空格！")
    			return false
    		}else{
    			$("#checkDepartmentName").text("");
        		return true;
    		}
    	}
    }
    function checkDescription(){
    	var departmentDescription = $("#departmentDescription").val();
    	if(departmentDescription == ""){
    		$("#checkDepartmentDescription").text("不能为空！");
    		return false;
    	}else{
    		if(/\s/.test(departmentDescription)){
    			$("#checkDepartmentDescription").text("不能有空格！")
    			return false
    		}else{
    			$("#checkDepartmentDescription").text("");
        		return true;
    		}
    	}
    }
    function checkAll(){
    	return checkName()&&checkDescription();
    }
</script>
</body>
</html>