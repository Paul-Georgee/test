<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
		
			cssPath : '/kind/kindeditor/plugins/code/prettify.css',
			uploadJson : '/kind/kindeditor/jsp/upload_json.jsp?dirPath=bbs',
			fileManagerJson : '/kind/kindeditor/jsp/file_manager_json.jsp?dirPath=bbs',
			
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
				
            }
        }
        $(function(){
            $("#pageUL").bootstrapPaginator(ops)
        })
	</script>
</head>
<body>
 <div style="background-color: white;width: 100%;height: 500px;margin: auto">
         <div style="height: 100px;width: 90%;margin: auto">
             <h1 >写邮件</h1>
             <div style="margin-left: 20%">
             <span id="addressee">收件人:</span>
             			<button class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="margin-left: 20px">
						  选择收件人
						</button>
						<!-- Modal -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
						      </div>
						      <div class="modal-body">
						      	<form class="form-inline" role="form">
						            姓名:
						            <div class="form-group">
						                <input type="text" class="form-control" >
						            </div>
						            <button type="submit" class="btn btn-default">搜索</button>
						        </form>
						        <table class="table table-striped" style="text-align: center">
							            <tr>
							                <td>选项</td>
							                <td>姓名</td>
							                <td>部门</td>
							                <td>职位</td>
							            </tr>
							            <tr>
							                <td><input type="checkbox" name="test" value="张三"></td>
							                <td>张三</td>
							                <td>市场部</td>
							                <td>业务员</td>
							            </tr>
							            <tr>
							                <td><input type="checkbox" name="test" value="李四"></td>
							                <td>张三</td>
							                <td>市场部</td>
							                <td>业务员</td>
							            </tr>
							            <tr>
							                <td><input type="checkbox" name="test" value="王五"></td>
							                <td>张三</td>
							                <td>市场部</td>
							                <td>业务员</td>
							            </tr>
							            <tr>
							                <td><input type="checkbox" name="test" value="赵六"></td>
							                <td>张三</td>
							                <td>市场部</td>
							                <td>业务员</td>
							            </tr>
							        </table>
							        <div style="font-size:20px;text-align: center">
										<ul  id="pageUL"></ul>
									</div>
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						        <button type="submit" class="btn btn-primary" onclick="add()">添加</button>
						      </div>
						    </div><!-- /.modal-content -->
						  </div><!-- /.modal-dialog -->
						</div>
						<div style="height: 20px;width: 100px"></div>
             </div>
         </div><br>
        </div>
        <script type="text/javascript">
        
        function add(){ 
        	var obj=document.getElementsByName('test'); 
        	//选择所有name="'test'"的对象，返回数组 
        	//取到对象数组后，我们来循环检测它是不是被选中 
        	var s=''; 
        	for(var i=0; i<obj.length; i++){ 
        		if(obj[i].checked){
        			s+="<span class='a' style='background:red' name='"+i+"'>"+obj[i].value+','+"</span>";
        		} //如果选中，将valueaz添加到变量s中 
        	} 
        	//那么现在来检测s的值就知道选中的复选框的值了 
        	alert(s==''?'你还没有选择任何内容！':s); 
        	$("#addressee").html("收件人:"+s);
        	$(".a").attr(name);
        	} 
        
        </script>
</body>
</html>