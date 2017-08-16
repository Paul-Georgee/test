<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${post.title}</title>

    <link rel="stylesheet" href="/ChinaLife/jsp/admin/css/project-style.css"/>
    <link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">



    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js" type="text/javascript"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <style>
        .divTitle{
            text-align: left;
            font-family: "华文彩云";
            padding-left: 20px;
            height: 55px;
            overflow:hidden;
        }
        .divInp{
            width: 900px;
            height:30px;
        }
        .inp-form-div{
            width:150px;
            margin-right:0px;
            margin-left: 10px;
        }
        .inp-name{
            width:80px;
            margin-right:0px;
            margin-left: 0px;
            text-align: right;
        }
        .inp_add{
            margin: auto;
        }
        .modal-dialog {
            margin:20px auto;
            height: 500px;
            width: 600px;
        }
        .forum-dl{
            margin-bottom: 10px;
        }
        .forum-dl dd{
            margin-left: 90px;
        }
        .forum-dl dt{
            width: 80px;
        }
        dd img{
            height: 100px;
            width: 100px;
        }
    </style>
</head>
<body>
<div class="content" >
    <div id="div1" class="divTitle">
        <h2 style="display: block;float: left;">${post.title}</h2>
        <div class="inp-name pull-left" style="margin-top:20px;">
        </div>
    </div>
    <div id="div2" class="divInp">
    <div class="inp-name pull-left">
    </div>
    </div>
    <div id="div3" class="divTible" style="overflow: auto">

        <table class="table table-striped">

            <tr>
                <td>
                    <dl class="dl-form dl-horizontal forum-dl">
                        <dd><img src="/ChinaLife/images/${post.authorAvatar }"></dd>
                    </dl>
                    <dl class="dl-form dl-horizontal forum-dl">
                        <dd>楼主:${post.authorName}</dd>
                        <dd> </dd>
                        <dd>${post.postTime }</dd>
                    </dl>
                </td>
                <td>
                    <dl class="dl-form dl-horizontal forum-dl">
                        <dd>${post.content}</dd>
                    </dl>
                    <dl class="dl-form dl-horizontal forum-dl" style="text-align: right;">
                    <c:if test="${employee.role=='超级管理员' or employee.role=='管理员' }">
                        <dd><a href="/ChinaLife/public/forum/posts/del/${post.id}.do">删除</a>
                        </dd>
                    </c:if>
                    </dl>
                </td>
            </tr>
			<c:forEach items="${post.comments }" var="comment" varStatus="status">
			<tr>
                <td>
                    <dl class="dl-form dl-horizontal forum-dl">
                        <dd><img src="/ChinaLife/images/${comment.avatar }"></dd>
                    </dl>
                    <dl class="dl-form dl-horizontal forum-dl">
                        <dd>${comment.commenter }</dd>
                        <dd>${status.index+1}楼</dd>
                        <dd>${comment.commentTime }</dd>
                    </dl>
                </td>
                <td>
                    <dl class="dl-form dl-horizontal forum-dl">
                        <dd>${comment.content }</dd>
                    </dl>
                    <dl class="dl-form dl-horizontal forum-dl" style="text-align: right;">
                    <c:if test="${employee.role=='超级管理员' or employee.role=='管理员' }">
                        <dd><a href="/ChinaLife/public/forum/comments/del/${post.id}.do">删除</a>
                        </dd>
                
                    </c:if>
                    </dl>
                </td>
            </tr>
			</c:forEach>
        </table>
        <hr>
        <div>
        	<form method="post" action="/ChinaLife/public/forum/comment.do">
        	    <input type="hidden" name="commenterId"  value="1">
                <input type="hidden" name="postId" value="${post.id}">
        		<dl class="dl-form dl-horizontal forum-dl" style="text-align: right;">
	                <dd> 回复:</dd>
	                <dd>
	                    <textarea class="form-control" rows="3" style="width:90%; resize: none;"
	                     placeholder="输入回复内容" name="content"></textarea>
	                </dd>
	                <dd>
	                	<div class="inp-name pull-left" style="margin-top:10px;">
			                <button type="submit" class="btn_refer btn btn-primary btn-sm">回复</button>
			            </div>
	                </dd>
            	</dl>
	
        	</form>
        </div>

    </div>
</div>
</body>

<script>
    $("#goback").click(function(){
        window.location.href="/ChinaLife/jsp/admin/forumMain.jsp";
    });
	
    function check(){
    	var content = $("input[name='content']").val();
    	if (content.length!=0) {
			
		}
    }


</script>

</html>