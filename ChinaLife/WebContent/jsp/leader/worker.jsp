<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有员工信息</title>

    <link rel="stylesheet" href="/ChinaLife/jsp/leader/css/project-style.css"/>
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
        .form-group{
            margin-bottom: 0px;
        }
        .modal-dialog{
        	width:800px;
        }
        #div3{
        	min-height:300px;
        }
        .input-sm{
     		padding-top:0px;
		}
    </style>
	
	<script type="text/javascript">
	   var ops = {
	            bootstrapMajorVersion:3,   //bootstrap版本
	            currentPage: 1,    //当前页码
	            totalPages: 12,   //总页数
	            numberOfPages:6,  //页面上最多显示多少页码
	            onPageClicked:function(e,ev,type,page){//页码点击事件
	//                alert(page);
	            	cutPage(page);
	            }
	        }
	    $(function(){   
	        cutPage(1);
	        getDepart();
	        $("#pageUL").bootstrapPaginator(ops);
	    });
	   
	   function getDepart(){
		   $.post("/ChinaLife/departList/getDepart.do","",
				   function(info){
//			   alert(JSON.stringify(info));
			   var depart = "<option value=''>所有</option>";
			   for(var i=0;i<info.length;i++){
				   var obj = info[i];
				   depart += "<option value='"+obj.id+"'>"+obj.departName+"</option>";
			   }
			   $("#depart").html(depart);
		   },"json");
	   }
	   
	    function cutPage(pn){
	        $.post("/ChinaLife/employees/findByItem.do","pageNo=" + pn +"&" +
	        		$("#f1").serialize(),
	        	function(info){
	      		var str = "";
	             for(var i=0;i<info.objects.length;i++){
	              	var obj = info.objects[i];
 	              	str +=  "<tr index='"+obj.id+"'>"+
			              	"<td><a  data-toggle='modal' data-target='#myModal' onclick='showInfo("+obj.id+")' >"+obj.trueName+"</a></td>"+
			                "<td>"+obj.gender+"</td>"+
			                "<td>"+obj.tel+"</td>"+
			                "<td>"+obj.department+"</td>"+
			                "<td>"+obj.duty+"</td>"+
	            			"</tr>"; 
	              }
//             	 alert(JSON.stringify(str));
	              
	              $("#data").html(str);
	  
	              if(pn == 1){
	              	ops.totalPages = info.pages;
	              	$("#pageUL").bootstrapPaginator(ops);
	              }                     
	        },"json"); 
	    }
	    
	    
	    function showInfo(id){
	    	$.post("/ChinaLife/employees/findById.do","id="+id,
	    		function(info){
	    			$("#img").html("<img src='/ChinaLife/images/"+info.avatar+"' style='height: 200px;width: 200px'>");
	    			$("#u1").html("<dt>姓名</dt><dd>"+info.trueName+"</dd>");
	    			$("#gender").html("<dt>性别</dt><dd>"+info.gender+"</dd>");
	    			$("#duty").html("<dt>职务</dt><dd>"+info.duty+"</dd>");
	    			$("#departName").html("<dt>部门</dt><dd>"+info.department+"</dd>");
	    			$("#tel").html("<dt>电话</dt><dd>"+info.tel+"</dd>");
	    			
	    			if(info.trains.length > 0){
	    				$("#trainHead").html("<tr><th >培训内容</th><th >培训时间</th><th >成绩</th></tr>");
	    			}
	    			
	    			var str = "";
	    			for(var i=0;i<info.trains.length;i++){
	    				var obj = info.trains[i];
	    				str += "<tr><td>"+obj.content+"</td><td>"+obj.trainTime+"</td>"+
	    					   "<td>"+obj.point+"</td></tr>";
	    			}
	    			$("#trainData").html(str);
	    	},"json");	
	    }
	</script>
</head>
<body>
<div class="content">
    <div id="div1" class="divTitle"><h2>员工信息查看</h2></div>
    <div id="div2" class="divInp">
        <form id="f1">
            <div class="inp-name pull-left">
                <label class="lab_Name control-label" >姓名:</label>
            </div>
            <div class="inp-form-div pull-left">
                <input class="input-sm" type="text" name="trueName"/>
            </div>
            <div class="inp-name pull-left">
                <label class="lab_Home control-label">部门:</label>
            </div>
            <div class="inp-form-div pull-left">       
                <select class="input-sm" id="depart" name="departId">
                </select>
            </div>
            <div class="inp-name pull-left">
                <label class="lab_Home control-label">职务:</label>
            </div>
            <div class="inp-form-div pull-left">
                <input class="input-sm" type="text" name="duty"/>
            </div>
            <div class="inp-name pull-left">
                <button type="button" class="btn_refer btn btn-warning btn-sm" onclick="cutPage(1)">查询</button>
            </div>
        </form>
    </div>
    <div id="div3" class="divTible">
        <table class="mytable table table-striped table-bordered table-hover">
        	<thead>
        		<tr>
	                <th >姓名</th>
	                <th >性别</th>
	                <th >电话</th>
	                <th >部门</th>
	                <th >职务</th>
        	    </tr>
        	</thead>
        	<tbody id="data">
       
        	</tbody>
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
                            <div class=" pull-left left-make">
                                <dl class="dl-form dl-horizontal">
                                    <dt>照片</dt>
                                    <dd id="img"></dd>
                                </dl>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class=" pull-left left-make">
                                <dl class="dl-form dl-horizontal" id="u1">     
                                </dl>
                            </div>
                            <div class=" pull-left left-make">
                                <dl class="dl-form dl-horizontal" id="gender">
                                  
                                </dl>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class=" pull-left left-make">
                                <dl class="dl-form dl-horizontal" id="duty">
                                   
                                </dl>
                            </div>
                            <div class=" pull-left left-make">
                                <dl class="dl-form dl-horizontal" id="departName">
                                
                                </dl>
                            </div>
                        </div>
                        <div class="form-group">
                            <dl class="dl-form dl-horizontal" id="tel">
                                
                            </dl>
                        </div>

                        <div class="form-group">
                            <table class="mytable table table-striped table-bordered table-hover">
                                <thead id="trainHead">
                                	
                                </thead>
                                <tbody id="trainData">
                                	
                                </tbody>
                               
                                
                            </table>
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
</html>