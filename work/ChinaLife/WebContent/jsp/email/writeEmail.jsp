<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="/ChinaLife/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="/ChinaLife/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="/ChinaLife/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="/ChinaLife/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="/ChinaLife/kindeditor/plugins/code/prettify.js"></script>
	<link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>
	<script>
	
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
	var ops = {
            bootstrapMajorVersion:3,      //bootstrap版本
            currentPage:1,    //当前页码
            totalPages:12,    //总页数
            numberOfPages:5,  //页面上最多显示多少页码
            onPageClicked:function(e,ev,type,page){   // 页码点击事件
				cutPage(page)
            }
        }
	function showAllPeople(){
		cutPage(1);
	}
	function cutPage(pn){
		$.post("/ChinaLife/sendEmail/findByItemForUsers.do","pageNo="+pn+"&"+$("#f1").serialize(),function(info){
			var str = "";
			for(var i = 0; i < info.objects.length; i++){
				var obj = info.objects[i];
				str += "<tr><td><input type='checkbox' name='test' value='"+obj.id+"'></td><td>"+obj.trueName+"</td><td>"+obj.department+"</td>"+
				"<td>"+obj.duty+"</td></tr>";
			}
			$("#data").html(str);
			if(pn == 1){
				ops.totalPages = info.pages;
				$("#pageUL").bootstrapPaginator(ops);
			}
		},"json")
	}
	</script>
</head>
<body>
 <div style="background-color: white;width: 100%;height: 500px;margin: auto">
         <div style="height: 100px;width: 90%;margin: auto">
             <h1 >写邮件</h1>
             <div style="margin-left: 20%">
             <span id="addressee">收件人:</span><span id="receiver"></span>
             			<button class="btn btn-primary" onclick="showAllPeople()" data-toggle="modal" data-target="#myModal" style="margin-left: 20px" >
						  选择收件人
						</button><span id="checkRe" style="color:red"></span>
						
						<!-- Modal -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						        <h4 class="modal-title" id="myModalLabel">选择收件人</h4>
						      </div>
						      <div class="modal-body">
						      	<form class="form-inline" role="form" id="f1">
						            姓名:
						            <div class="form-group">
						                <input type="text" class="form-control" name="userName">
						            </div>
						            <input type="button" class="btn btn-default" onclick="cutPage(1)" value="搜索">
						        </form>
						        <table class="table table-striped" style="text-align: center">
						        	<thead>
							            <tr>
							                <td>选项</td>
							                <td>姓名</td>
							                <td>部门</td>
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
						        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="ChoiceMore()">确定</button>
						      </div>
						    </div><!-- /.modal-content -->
						  </div><!-- /.modal-dialog -->
						</div>
						<div style="height: 20px;width: 100px"></div>
             <form class="form-inline" action="/ChinaLife/sendEmail/sendAddEmail.do" 
             method="post" enctype="multipart/form-data" onsubmit="return confirm()">
                 <input type="hidden" name="array" id="receivers">
                 <input type="hidden" name="nameArray" id="receiverStr">
                 
                 <div class="form-group ">
                     标题:<input type="text" class="form-control" style="margin-left: 35px" name="title" required="required">
                 </div><br>
                 <div class="form-group ">
                     
                 </div><br>
                 <br>
            选择附件：<input type="file" name="eamilAttachment" ><br><br> 
         	内容：<textarea name="content" cols="100" rows="8" id="checkContent" onblur="checkCon()"></textarea><span id="contentSpan"></span><br />
			<!-- <input type="submit" name="button" value="提交" /> -->
			<button type="submit" class="btn btn-primary" >发送</button>
			<button type="button" class="btn btn-primary" onclick="go()">返回</button>
            </form>
             </div>
         </div><br>
        </div>
        <script type="text/javascript">
		var array = [];
		var nameArray = [];
        	function ChoiceMore(){

        		$.each($('input:checkbox'),function(){
                    if(this.checked){
                    	 array.push($(this).val());
                         nameArray.push($(this).parent().next().html())
                    }
                })
                $("#receivers").val(array);
        		$("#receiver").html(nameArray.toString());
        		
        		$("#receiverStr").val(nameArray);
        	}
        	function go(){
                location.href = "/ChinaLife/jsp/email/outbox.jsp"
            }
        	// 验证是否有收件人
        	function confirm(){
        		if (array.length==0 && nameArray.length==0) {
        			$("#checkRe").text("请选择收件人!");
					return false;
				}else{
					$("#checkRe").text("");
	        		return true;
				}
        	}
        	// 验证是否有附件
        	
        </script>
        
</body>
</html>