<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论坛版块</title>

    <link rel="stylesheet" href="/ChinaLife/jsp/admin/css/project-style.css"/>
    <link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">

    <link rel="stylesheet" href="/ChinaLife/kindeditor/themes/default/default.css" />
    <link rel="stylesheet" href="/ChinaLife/kindeditor/plugins/code/prettify.css" />

    <script charset="utf-8" src="/ChinaLife/kindeditor/kindeditor.js"></script>
    <script charset="utf-8" src="/ChinaLife/kindeditor/lang/zh_CN.js"></script>
    <script charset="utf-8" src="/ChinaLife/kindeditor/plugins/code/prettify.js"></script>

    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js" type="text/javascript"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>
    <style>
        .divTitle{
            text-align: left;
            font-family: "华文彩云";
            padding-left: 20px;
            height: 55px;
            overflow:hidden;
        }
        .divInp{
            width: 1100px;
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
            width: 1000px;
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
    </style>
    <script type="text/javascript">
    var array = [];
    var ops = {
        bootstrapMajorVersion:3,      //bootstrap版本
        currentPage:1,    //当前页码
        totalPages:12,    //总页数
        numberOfPages:5,  //页面上最多显示多少页码
        onPageClicked:function(e,ev,type,page){   // 页码点击事件
			index(page);
        }
    }
    
    $(function(){
    	index(1);
    })
    
    function index(pageNo){
        $.post("/ChinaLife/public/forum/posts.do","pageNo="+pageNo+"&"+$("#search").serialize(),
        		function(data){
        	//alert(JSON.stringify(data))
        	var str = "";
        	ops.totalPages=data.pages;
        	ops.numberOfPages=data.pages;
        	$("#pageUL").bootstrapPaginator(ops);
        	for(var i=0;i<data.objects.length;i++){
        		var post = data.objects[i];
                str+="<tr><td><dl class='dl-form dl-horizontal forum-dl'>"+
                        "<dd><a href='/ChinaLife/public/forum/posts/"+post.id+".do'>"+
                        post.title+"</a></dd>"+
                    "</dl>"+
                "</td><td><dl class='dl-form dl-horizontal forum-dl'>"+
                        "<dt>作者：</dt><dd>"+post.authorName+"</dd>"+
                    "</dl><dl class='dl-form dl-horizontal forum-dl'>"+
                       " <dt>回帖数：</dt><dd>"+post.count+"</dd>"+
                    "</dl></td>"+
                "<td><dl class='dl-form dl-horizontal forum-dl'>"+
                        "<dt>发帖时间：</dt><dd>"+post.postTime+"</dd>"+
                   " </dl>"+
                "</td><td>"+
                    "<dl class='dl-form dl-horizontal forum-dl'>"+
                        "<dt></dt>"+
                    "</dl></td></tr>";
                    $("#forumId").val(post.forumId);
        	}
        	$("#data").html(str);
        },"json")
    }
    
    </script>
</head>
<body>
<div class="content">
    <div id="div1" class="divTitle">
        <h2 style="display: block;float: left;"></h2>
    </div>
    <div id="div2" class="divInp">
        <form id="search">
        	<input class="inp input-sm" type="hidden" name="forumId" value="${forumId }"/>
            <div class="inp-name pull-left">
                <label class="lab_Name control-label">帖子名称:</label>
            </div>
            <div class="inp-form-div pull-left">
                <input class="inp input-sm" type="text" name="title"/>
            </div>
            <div class="inp-name pull-left">
                <label class="lab_Home control-label">楼主:</label>
            </div>
            <div class="inp-form-div pull-left">
                <input class="inp form-control input-sm" type="text" name="username"/>
            </div>
            <div class="inp-name pull-left">
                <label class="lab_Name control-label">时间段:</label>
            </div>
            <div class="inp-form-div pull-left">
                <input class="inp input-sm" type="text" name="start"/>
            </div>
            <div class="pull-left" style="margin-left: 5px;">
                <label class="lab_Name control-label">~</label>
            </div>
            <div class="inp-form-div pull-left">
                <input class="inp input-sm" type="text" name="end"/>
            </div>
            <div class="inp-name pull-left">
                <button type="button" class="btn_refer btn btn-primary btn-sm" 
                onclick="index(1)">查询</button>
            </div>
        </form>
        <div class="inp-name pull-left">
            <button type="submit" id="add"  data-toggle="modal" data-target="#myModal" class="btn_refer btn btn-warning btn-sm">添加新帖</button>
        </div>
    </div>
    <div id="div3" class="divTible">

        <table class="table table-striped" id="data">

        </table>

		<div>
			<ul id="pageUL">
			
			</ul>
		</div>
    </div>

    <!-- Modal 1 -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" >
            <div class="modal-content" id="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel1">发布新帖</h4>
                </div>
                <form name="example" class="form-horizontal" role="form" 
                action="/ChinaLife/public/forum/publish.do" method="post">
                <input type="hidden" name="forumId" id="forumId">
                <input type="hidden" name="authorId" value="1">
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">主题</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control"  placeholder="主题" name="title">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">内容</label>
                            <div class="col-sm-10">
                                <textarea id="postMsg" name="content" class="" placeholder="请输入内容" cols="100" rows="50" style=" width:100%;height:300px; resize: none"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="div_btn modal-footer">
                        <button type="submit" class="inp_add btn btn-primary">发布</button>
                        <button  class="inp_add btn btn-default" data-dismiss="modal">取消</button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->	
</div>
</body>

<script>
    $("#goback").click(function(){
        window.location.href="forum.jsp";
    });

    KindEditor.ready(function(K) {

        var editor1 = K.create('textarea[name="content"]', {

            cssPath : '/ChinaLife/kindeditor/plugins/code/prettify.css',
            uploadJson : '/ChinaLife/kindeditor/jsp/upload_json.jsp?dirPath=bbs',
            fileManagerJson : '/ChinaLife/kindeditor/jsp/file_manager_json.jsp?dirPath=bbs',

            allowFileManager : true,
            afterCreate : function() {
                var self = this;

                K.ctrl(document, 13, function() {
                    self.sync();
                    document.forms['example'].submit();

                });

                K.ctrl(self.edit.doc, 13, function() {
                    self.sync();
                    document.forms['example'].submit();

                });

            }

        });

        prettyPrint();

    });

</script>

</html>