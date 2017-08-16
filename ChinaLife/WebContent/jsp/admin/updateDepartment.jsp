<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>修改部门信息</title>
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
				cutPage(page)
            }
        }
        $(function(){
        	
        })
        function showPeople(){
        	cutPage(1);
        }
        function cutPage(pn){
        	$.post("/ChinaLife/department/findByItemForUser.do","pageNo="+pn+"&"+$("#f1").serialize(),function(info){
        		/* alert(JSON.stringify(info)); */
        		var str = "";
        		for(var i = 0; i < info.objects.length; i++){
        			var obj = info.objects[i];
        			str += "<tr><td><input type='radio' name='test' value='"+obj.id+"'></td>"+
        			"<td>"+obj.trueName+"</td><td>"+obj.gender+"</td><td>"+obj.department+"</td></tr>";
        		}
        		$("#data").html(str);
        		if(pn == 1){
    				ops.totalPages = info.pages;
    				$("#pageUL").bootstrapPaginator(ops);
    			}
        	},"json")
        }
    </script>
    <style type="text/css">
        span{
            font-size: 20px;
        }
    </style>
</head>
<body>
    <div class="row"style="height: 300px;width: 70%;margin: auto;">
        <h1>修改部门信息</h1>
        <div style="margin: auto;height: 50px;width: 800px;"></div>
        <div class="col-md-1" ></div>
        <div class="col-md-11" >
            <span>部门名称:</span><span>${ department.departName }</span>
        </div><br><br><br>
        <div class="col-md-1" ></div>
        <div class="col-md-11" >
            <span>部门描述:</span><span>${ department.departDescription }</span>
        </div><br><br><br>
         <div class="col-md-1" ></div>
         <form class="form-inline" role="form">
         <div class="col-md-3" >
         	<span>部门负责人:</span>
          </div>
          <div class="col-md-3" >
          	<div class="form-group">
                  <input type="text" class="form-control" value="原负责人：${ department.leader }" readonly="readonly" id="newName">
            </div>
          </div>
          </form>
         <div class="col-md-5" >
				<button class="btn btn-primary " data-toggle="modal" data-target="#myModal" onclick="showPeople()">
				 	更换负责人
				</button>
				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				        <h4 class="modal-title" id="myModalLabel">选择负责人</h4>
				      </div>
				      <div class="modal-body">
							<form class="form-inline" role="form" id="f1">
					            姓名:
					            <div class="form-group">
					                <input type="text" class="form-control" name="userName">
					            </div>
					            <input type=button onclick="cutPage(1)" value="搜索">
					        </form>
					        <div style="height: 30px;width: 10px"></div>
					        <table class="table table-striped" style="text-align: center">
						        <thead>
						            <tr>
						                <td>选项</td>
						                <td>姓名</td>
						                <td>性别</td>
						                <td>职位</td>
						            </tr>
						        </thead>
						        <tbody id="data"></tbody>
					        </table>
					        <div style="font-size:20px;text-align: center">
								<ul  id="pageUL"></ul>
							</div>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="ChoiceOne()">确定</button>
				      </div>
				    </div><!-- /.modal-content -->
				  </div><!-- /.modal-dialog -->
				</div>
         </div>
          <div style="margin: auto;height: 100px;width: 800px;">
          	
          </div>
         <div class="col-md-1" ></div>
         <div class="col-md-11" >
         	<form action="/ChinaLife/department/update.do" method="post">
         		<input type="hidden" name="departHeaderId" id="header" value="${ department.userId }">
         		<input type="hidden" name="departId" value="${ department.id }">
         		<c:if test="${ department.userId != null}" var="userId">
         			<input type="hidden" name="userId" value="${ department.userId }">
         		</c:if>
         		<c:if test="${ !userId }">
         			<input type="hidden" name="userId" value="0">
         		</c:if>
         		<button type="submit" class="btn btn-primary" id="abc">修改</button>
         		<button type="button" class="btn btn-primary" onclick="go()">返回</button>
         	</form>
         	
         </div>
    </div>
    <script type="text/javascript">
        function go(){
            location.href = "/ChinaLife/jsp/admin/department.jsp"
        }
        function ChoiceOne(){
        	var departHeaderId;
        	var obj=document.getElementsByName('test'); 
        	for (var i = 0; i < obj.length; i++) {
                if (obj[i].checked == true) {
                    departHeaderId = obj[i].value;
                    $("#header").val(departHeaderId);
                    var val=$('input:radio[name="test"]:checked').parent().next().html();
                	$("#newName").attr("value","新负责人："+val);
                    break;
                }
            }
        }
    </script>
</body>
</html>