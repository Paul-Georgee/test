<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论坛首页</title>

    <link rel="stylesheet" href="/ChinaLife/jsp/admin/css/project-style.css"/>
    <link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js" type="text/javascript"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <style>
        .divTitle{
            font-family: "华文彩云";
        }
        .divInp{
            width: 1000px;
            height:50px;
        }
        .inp-form-div{
            width:150px;
            margin-right:0px;
            margin-left: 10px;
        }
        .inp-name{
            width:80px;
            margin-right:0px;
            margin-left: 40px;
            text-align: right;
        }
        .inp_add{
            margin: auto;
        }
        .modal-dialog {
            margin:100px auto;
            width: 600px;
        }
    </style>
</head>
<body>
<div class="content">
    <div id="div1" class="divTitle">
    <c:if test="${employee.role=='超级管理员' or  employee.role=='管理员' }" var="admin">
    	<h2>论坛维护</h2>
    </c:if>
    <c:if test="${!admin }">
    	<h2>论坛首页</h2>
    </c:if>
    </div>
    <div id="div2" class="divInp">
        <div class="inp-name pull-left">
        <c:if test="${employee.role=='超级管理员' or  employee.role=='管理员' }">
            <button type="submit" id="add"  data-toggle="modal" data-target="#myModal" class="btn_refer btn btn-primary btn-sm">添加版块</button>
        </c:if>
        </div>
    </div>
    <div id="div3" class="divTible">
        <table class="mytable table table-striped table-bordered table-hover">
            <tr>
                <th >版块名称</th>
                <th >版主</th>
                <th >主贴数量</th>
            </tr>
            <c:forEach items="${forums }" var="forum">
	            <tr>
	                <td><a href="/ChinaLife/public/forum/${forum.id }.do">${forum.forumName}</a></td>
	                <td>${forum.moderator }</td>
	                <td>${forum.articles }</td>
	            </tr>
            </c:forEach>
        </table>
    </div>

    <!-- Modal 1 -->
    <div class="modal fade" id="myModal" style="margin-left: 0px;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content" id="modal-content">
                <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel1">添加新版块</h4>
                </div>
                <form class="form-horizontal" role="form">
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">版块名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control"  placeholder="版块名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  for="harm1" class="col-sm-2 control-label">版主</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="harm1" placeholder="版主">
                            </div>
                        </div>
                    </div>
                    <div class="div_btn modal-footer">
                        <button type="submit" class="inp_add btn btn-primary" data-dismiss="modal">确定</button>
                        <button  class="inp_add btn btn-default" data-dismiss="modal">取消</button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>
</body>

</html>