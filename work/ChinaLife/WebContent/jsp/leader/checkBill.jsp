<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>理赔审核</title>

    <link rel="stylesheet" href="css/project-style.css"/>
    <link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">

    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js" type="text/javascript"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>
   
    <script src="/ChinaLife/laydate/laydate.js"></script>
   
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
        .modal{
        	margin:10px;
        }
        .modal-dialog {
            width: 800px;
        }
        .form-group{
            margin-bottom: 0px;
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
	    });	   
	   
	    function cutPage(pn){
	        $.post("/ChinaLife/gurantee/findCheckBill.do","pageNo=" + pn ,
	        	function(info){
	      		var str = "";
	             for(var i=0;i<info.length;i++){
	              	var obj = info[i];
	              	
 	              	str +=  "<tr>"+
 	              			"<td><a data-toggle='modal' data-target='#myModal' onclick='showInfo("+obj.audit.id+")'>"+
 	              				obj.number+"</a></td>"+
			                "<td>"+obj.favoree+"</td>"+
			                "<td>"+obj.insureTime+"</td>"+		
	            			"</tr>"; 
	              }
	        
	              $("#data").html(str);
	              if(pn == 1){
	              	ops.totalPages = info.pages;
	              }                     
	        },"json"); 
	    }
	     
	    function showInfo(id){
	    	$.post("/ChinaLife/gurantee/findCheckBill.do","id="+id,
	    		function(info){	    			
	    			
					for(var i=0;i<info.length;i++){
						var obj = info[i];
						if(obj.id == id){
//			    			alert(obj.audit.policyId);								
							$("#getId").html("<input type='hidden' name='id' value='"+obj.audit.policyId+"'/>");
							
							$("#clientName").html("<dt>投保人</dt><dd>"+obj.client.clientName+"</dd>");
			    			$("#gender").html("<dt>性别</dt><dd>"+obj.client.gender+"</dd>");
			    			$("#tel").html("<dt>电话</dt><dd>"+obj.client.tel+"</dd>");
			    			$("#profession").html("<dt>职务</dt><dd>"+obj.client.profession+"</dd>");
			    			$("#insuName").html("<dt>部门</dt><dd>"+obj.insurance.insuName+"</dd>");
			    			$("#price").html("<dt>资费</dt><dd>"+obj.insurance.price+"</dd>");
			    			$("#insureTime").html("<dt>入保时间</dt><dd>"+obj.insureTime+"</dd>");
			    			$("#content").html("<dt>保险范围</dt><dd><textarea class='form-control' rows='3' readonly='true'  style=' width:80%; resize: none'>"+
			    					obj.insurance.content+"</textarea></dd>");
			    			$("#applyReason").html("<dt>理赔理由</dt><dd><textarea class='form-control' rows='3' readonly='true'  style=' width:80%; resize: none'>"+
			    					obj.audit.applyReason+"</textarea></dd>");
			    			
							break;
						}
					}
	
	    	},"json");	
	    }	  
	    
	    function check(){
	   			var reg = /^\S{1,}$/
	    	
	   		if(reg.test($("#auditReason").val())){
//	    	   if($("#auditReason").val() != "" ){
	    		   $("#btn").removeAttr("disabled");
	    	   }else{
	    		   alert("审批内容为不能为空！");
	    		   $("#btn").attr("disabled","disabled");
	    	   }
	    }
	    
	    function chooseNo(){
	    	$("#btn").removeAttr("disabled");
	    }
	    
	    $("#auditReason").focusout(function(){
	    	alert("审批内容为不能为空！");
	    });
	</script>
    
</head>
<body>
<div class="content">
    <div id="div1" class="divTitle"><h2>理赔审核</h2></div>

    <div id="div3" class="divTible">
        <table class="mytable table table-striped table-bordered table-hover">
        	<thead>
				<tr >
                <th >保险单号</th>
                <th >受益人</th>
                <th ></th>
          		</tr>        	
        	</thead>
        	<tbody id="data">
        	
        	</tbody>      
        </table>
        <div style="font-size: 20px;text-align: center">
            <ul class="pagination" id="pageUL"></ul>
    	</div>
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
                        </div>
                        <div class="form-group">
                            <div class="">
                                <dl class="dl-form dl-horizontal" id="content">
                                    
                                </dl>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class=" ">
                                <dl class="dl-form dl-horizontal" id="applyReason">
                                    
                                </dl>
                            </div>
                        </div>
		<form action="/ChinaLife/gurantee/update.do" method="post" class="form-horizontal" role="form">
                        <div id="getId"></div>
                        <div class="form-group">
                            <div class=" pull-left left-make">
                                <dl class="dl-form dl-horizontal">
                                    <dt>审判状态</dt>
                                    <dd><label>
                                        <input checked="true" type="radio" name="Radios" id="radio1" value="yes" onchange="check()">
                                        同意
                                    </label></dd>
                                </dl>
                            </div>
                            <div class="pull-left left-make">
                                <label>
                                    <input type="radio" name="Radios" id="radio2" value="no" onchange="chooseNo()">
                                        驳回
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class=" ">
                                <dl class="dl-form dl-horizontal">
                                    <dt>审批意见</dt>
                                    <dd><textarea id="auditReason" onkeyup="check()" name="auditReason" class="form-control" rows="3" style="width:80%; resize: none;"></textarea></dd>
                                </dl>
                            </div>
                        </div>
                    
                </div>
                <div class="div_btn modal-footer">
                    <button id="btn" type="submit" class="inp_add btn btn-primary" disabled="disabled" >提交</button>
                    <button class="inp_add btn btn-default" data-dismiss="modal">取消</button>
                </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

</div>
</body>


</html>