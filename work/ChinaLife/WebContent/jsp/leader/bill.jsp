<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有表单信息</title>

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
            width: 1100px;
            height:60px;
        }
        .inp-form-div{
            width:110px;
            margin-right:0px;
            margin-left: 10px;
        }
        .inp-name{
            width:80px;
            margin-right:0px;
            margin-left: 30px;
            text-align: right;
        }
        .inp_add{
            margin: auto;
        }
        .modal-dialog {
            margin:10px auto;
            height: 500px;
            width: 800px;
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
            numberOfPages:5,  //页面上最多显示多少页码
            onPageClicked:function(e,ev,type,page){//页码点击事件
            	cutPage(page);
            }
        }

	    $(function(){   
	        cutPage(1);
	        getDepart();
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
    	
 	   function getDepart(){
		   $.post("/ChinaLife/departList/getDepart.do","",
				   function(info){
//			   alert(JSON.stringify(info));
			   var depart = "<option value=''>所有</option>";
			   for(var i=0;i<info.length;i++){
				   var obj = info[i];
				   depart += "<option value='"+obj.id+"'>"+obj.departName+"</option>";
			   }
			   
			   $("#departmentId").html(depart);

		   },"json");
	   }
	   
	    function cutPage(pn){
	        $.post("/ChinaLife/gurantee/findByItem.do","pageNo=" + pn +"&" +$("#f1").serialize(),
	        	function(info){
	        	
//	        	alert(JSON.stringify(info));

	      		var str = "";
	             for(var i=0;i<info.objects.length;i++){
	              	var obj = info.objects[i];
	              	
 	              	str +=  "<tr>"+
			                "<td>"+obj.number+"</td>"+
			                "<td>"+obj.favoree+"</td>"+
			                "<td>"+obj.insureTime+"</td>"+
			                "<td>"+obj.state+"</td>"+
			                "<td>"+obj.signer+"</td>"+
			                "<td><a data-toggle='modal' data-target='#myModal' onclick='showInfo("+obj.id+")' >查看</a></td>"+
	            			"</tr>"; 
	              }
	              $("#data").html(str);
	              if(pn == 1){
	              	ops.totalPages = info.pages;
	              	$("#pageUL").bootstrapPaginator(ops);
	              }                     
	        },"json"); 
	    }
	     
	    function showInfo(id){
	    	$.post("/ChinaLife/gurantee/findById.do","id="+id,
	    		function(info){
	    			$("#clientName").html("<dt>投保人</dt><dd>"+info.client.clientName+"</dd>");
	    			$("#gender").html("<dt>性别</dt><dd>"+info.client.gender+"</dd>");
	    			$("#tel").html("<dt>电话</dt><dd>"+info.client.tel+"</dd>");
	    			$("#profession").html("<dt>职务</dt><dd>"+info.client.profession+"</dd>");
	    			$("#insuName").html("<dt>险种</dt><dd>"+info.insurance.insuName+"</dd>");
	    			$("#price").html("<dt>资费</dt><dd>"+info.insurance.price+"</dd>");
	    			$("#insureTime").html("<dt>入保时间</dt><dd>"+info.insureTime+"</dd>");
	    			$("#content").html("<dt>保险范围</dt><dd><textarea class='form-control' rows='3' readonly='true'  style=' width:80%; resize: none'>"+
	    					info.insurance.content+"</textarea></dd>");
	    			if(info.audit.applyReason != null){
	    				$("#applyReason").html("<dt>理赔原因</dt><dd>"+info.audit.applyReason+"</dd>");
	    			}

	    	},"json");	
	    }	    
	</script>  
</head>
<body>
<div class="content">
    <div id="div1" class="divTitle"><h2>所有保单信息</h2></div>
    <div id="div2" class="divInp">
        <form id="f1">
            <div style="height: 40px;width: 100%;">
				<div class="inp-name pull-left">
                    <label class="lab_Name control-label">险种:</label>
                </div>
                <div class="inp-form-div pull-left">
                    <input class="input-sm" type="text" name="insureName"/>
                </div>            	
            

                <div class="inp-name pull-left">
                    <label class="lab_Home control-label">开始日期:</label>
                </div>
                <div class="inp-form-div pull-left">
                    <input class="input-sm" type="text" name="start" id="start" placeholder="格式xxxx-xx-xx" />
                </div>
            	 <div class="inp-name pull-left">
                    <label class="lab_Home control-label">结束日期:</label>
                </div>
                <div class="inp-form-div pull-left">
                    <input class="input-sm" type="text" name="end" id="end" placeholder="格式xxxx-xx-xx"/>
                </div>
                
                 <div class="inp-name pull-left">
                    <label class="lab_Home control-label">部门:</label>
                </div>
                <div class="inp-form-div pull-left">
                    <select class="input-sm" id="departmentId" name="departmentId"></select>
                </div>
            </div>

            <div style="height: 50px;width: 100%;">
                <div class="inp-name pull-left">
                    <label class="lab_Name control-label">投保人:</label>
                </div>
                <div class="inp-form-div pull-left">
                    <input class="input-sm" type="text" name="clientName"/>
                </div>                
                <div class="inp-name pull-left">
                    <label class="lab_Home control-label">签单人:</label>
                </div>
                <div class="inp-form-div pull-left">
                    <input class="input-sm" type="text" name="signer"/>
                </div>
                <div class="inp-name pull-left">
                    <label class="lab_Home control-label">保单状态:</label>
                </div>
                <div class="inp-form-div pull-left">
                    <select class="input-sm" name="state">
                    	<option value=''>所有</option>
                    	<option value="有效">有效</option>
                    	<option value="理赔中">理赔中</option>
                    	<option value="理赔失效">理赔失效</option>
                    </select>
                </div>
                <div class="inp-name pull-left">
                    <button id="btn" type="button" class="btn btn-primary btn-sm" style="width:120px;margin-left:50px;" onclick="testDate()">查询</button>
                </div>                
               
            </div>


        </form>
    </div>
    <div id="div3" class="divTible">
        <table class="mytable table table-striped table-bordered table-hover">
        	<thead>
	            <tr>
	                <th >保险单号</th>
	                <th >受益人</th>
	                <th >投保日期</th>
	                <th >保单状态</th>
	                <th >签单人</th>
	                <th >操作</th>
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
                    <h4 class="modal-title" id="myModalLabel1">保单详情</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <div class=" pull-left left-make">
                                <dl class="dl-form dl-horizontal" id="clientName">
                                   
                                </dl>
                            </div>
                            <div class="pull-left left-make">
                                <dl class="dl-form dl-horizontal" id="gender">
                                    
                                </dl>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class=" pull-left left-make">
                                <dl class="dl-form dl-horizontal" id="tel">
                                
                                </dl>
                            </div>
                            <div class="pull-left left-make">
                                <dl class="dl-form dl-horizontal" id="profession">
                      
                                </dl>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class=" pull-left left-make">
                                <dl class="dl-form dl-horizontal" id="insuName">
                                  
                                </dl>
                            </div>
                            <div class="pull-left left-make">
                                <dl class="dl-form dl-horizontal" id="price">
                                 
                                </dl>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class=" pull-left left-make">
                                <dl class="dl-form dl-horizontal" id="insureTime">
                               
                                </dl>
                            </div>
                            <div class="pull-left left-make">
                                <dl class="dl-form dl-horizontal" id="applyReason">
                                   
                                </dl>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class=" ">
                                <dl class="dl-form dl-horizontal" id="content">

                                </dl>
                            </div>

                        </div>
                    </form>
                </div>
                <div class="div_btn modal-footer">
                    <button class="inp_add btn btn-primary" data-dismiss="modal">确认</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>
</body>

</html>