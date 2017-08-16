<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看会议记录</title>

    <link rel="stylesheet" href="/ChinaLife/jsp/admin/css/project-style.css"/>
    <link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js" type="text/javascript"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>
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
            margin:40px auto;
            height: 500px;
            width: 600px;
        }
        .form-group{
            margin-bottom: 0px;
        }
        #div3{
        	min-height:300px;
        }
    </style>
    
    <script type="text/javascript">

	   var ops = {
	            bootstrapMajorVersion:3,   //bootstrap版本
	            currentPage: 1,    //当前页码
	            totalPages: 12,   //总页数
	            numberOfPages:6,  //页面上最多显示多少页码
	            onPageClicked:function(e,ev,type,page){//页码点击事件
	            	cutPage(page);
	            }
	        }
	    $(function(){    	
	        cutPage(1);
	    });	  
	   
       function testDate(){
           var reg1 = /^\d{4}-([1][0-2]|[0][0-9]){1}-([0-2][0-9]|[3][0-1]){1}$/;
           var reg2 = /^\S{1,}$/;
           if((reg1.test($("#start").val()) || !reg2.test($("#start").val()))&&(reg1.test($("#end").val()) || !reg2.test($("#end").val()))){
//           	if(reg1.test($("#start").val()) || !reg2.test($("#start").val())){	
//               alert("匹配！！");
               cutPage(1);
           }else{
               alert("时间格式错误！！");
           }
       }
	   
	    function cutPage(pn){
	        $.post("/ChinaLife/leadMeeting/findByItem.do","pageNo=" + pn +"&" +$("#f1").serialize(),
	        	function(info){
	        	
//	        	alert(JSON.stringify(info));

	      		var str = "";
	             for(var i=0;i<info.objects.length;i++){
	              	var obj = info.objects[i];
 	              	
	              	str +=  "<tr>"+
			              	"<td><a  data-toggle='modal' data-target='#myModal' onclick='showInfo("+obj.id+")' >"
			              		+obj.title+"</a></td>"+
			                "<td>"+obj.huiyiTime+"</td>"+
			                "<td>"+obj.state+"</td>"+
	            			"</tr>"; 
	              }
//           	 alert(JSON.stringify(str));
	              
	              $("#data").html(str);
	  
	              if(pn == 1){
	              	ops.totalPages = info.pages;
	              	$("#pageUL").bootstrapPaginator(ops);
	              }                     
	        },"json"); 
	    }
	    
	    
	    function showInfo(id){
	    	$.post("/ChinaLife/leadMeeting/findById.do","id="+id,
	    		function(info){
	//    			alert(JSON.stringify(info));	
	    		
	    			$("#title").html("<dt>会议主题</dt><dd>"+info.title+"</dd>");
	    			$("#huiyiTime").html("<dt>会议时间</dt><dd>"+info.huiyiTime+"</dd>");	    
	    			$("#location").html(" <dt>会议地点</dt><dd>"+info.location+"</dd>");	    
	    			$("#conferee").html("<dt>与会人员</dt><dd>"+info.conferee+"</dd>");
	    			$("#state").html("<dt>会议状态</dt><dd>"+info.state+"</dd>"); 			
	    			$("#content").html("<dt>会议内容</dt><dd><textarea class='form-control' rows='3' readonly='true'  style='width:80%; resize: none;'>"+
	    					info.content+"</textarea></dd>");
//					alert(info.content)
	    	},"json");	
	    }
    
	</script>
    
</head>
<body>
<div class="content">
    <div id="div1" class="divTitle"><h2>会议管理</h2></div>
    <div id="div2" class="divInp">
        <form id="f1">
            <div class="inp-name pull-left">
                <label class="lab_Name control-label">开始时间:</label>
            </div>
            <div class="inp-form-div pull-left">
                <input class="input-sm" type="text" name="start" id="start" placeholder="格式：1111-01-01"/>
            </div>
            <div class="inp-name pull-left">
                <label class="lab_Home control-label">结束时间:</label>
            </div>
            <div class="inp-form-div pull-left">
                <input class="  input-sm" type="text" name="end" id="end" placeholder="格式：1111-01-01"/>
            </div>
            <div class="inp-name pull-left">
                <label class="lab_Home control-label">会议主题:</label>
            </div>
            <div class="inp-form-div pull-left">
                <input class="  input-sm" type="text" name="title"/>
            </div>
            <div class="inp-name pull-left">
                <button type="button" class="btn btn-primary btn-sm" onclick="testDate()">查询</button>
            </div>
        </form>
    </div>
    <div id="div3" class="divTible">
        <table class="mytable table table-striped table-bordered table-hover">
            <thead>
            	<tr >
                <th >会议主题</th>
                <th >会议时间</th>
                <th >会议状态</th>
            	</tr>
            </thead>
            <tbody id="data"></tbody>
        </table>
    </div>
        <div style="font-size: 20px;text-align: center">
        	<ul class="pagination" id="pageUL"></ul>
    	</div>

    <!-- Modal 1 -->
    <div class="modal fade" id="myModal" style="margin-left: 0px;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content" id="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel1">员工信息详情</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form">                  
                    	<div class="form-group">
                            <div class=" pull-left">
                                <dl class="dl-form dl-horizontal" id="title"></dl>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class=" pull-left">
                                <dl class="dl-form dl-horizontal" id="huiyiTime"></dl>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class=" pull-left">
                                <dl class="dl-form dl-horizontal" id="location"></dl>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class=" pull-left">
                                <dl class="dl-form dl-horizontal" id="conferee"></dl>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class=" pull-left">
                                <dl class="dl-form dl-horizontal" id="state"></dl>
                            </div>
                        </div>
                        <div class="form-group">
                            <dl class="dl-form dl-horizontal" id="content"></dl>
                        </div>

                    </form>
                </div>
                <div class="div_btn modal-footer">
                    <button class="inp_add btn btn-primary" data-dismiss="modal">确定</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>
</body>

</body>

</html>