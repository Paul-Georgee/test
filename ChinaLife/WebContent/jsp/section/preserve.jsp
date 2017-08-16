<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门保单维护</title>
 <link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
   	<script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>
    <style type="text/css">
        .linear{
            background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(rgb(182,231,211)), to(#ffffff));/*谷歌*/
        }
    </style>
    <script type="text/javascript">    	
    	var ops = {
    	        bootstrapMajorVersion:3,      //bootstrap版本
    	        currentPage:1,    //当前页码
    	        numberOfPages:6,  //页面上最多显示多少页码
    	        onPageClicked:function(e,ev,type,page){   // 页码点击事件
    				cut(page)
    	        }
    	    }

    	$(function(){
    		cut(1)
    	})
    	
    	function cut(pn){
    		$.post("/ChinaLife/guratee/findByItem.do","pageNo="+pn+"&"+$("#f1").serialize(),function(info){
    			<%--alert(JSON.stringify(info))--%>
    			var str=""
    			for(var i=0;i<info.objects.length;i++){
    				var obj=info.objects[i];
    				str+="<tr>"+
    				"<td>"+obj.number+"</td><td>"+obj.favoree+"</td><td>"+obj.client.clientName+"</td><td>"+obj.insureTime+"</td><td>"+
    					obj.insurance.insuName+"</td><td>"+obj.signer+
    					"</td><td><a href='/ChinaLife/guratee/findGurantInfoUpdate.do?id="+obj.id+"'>保单理赔</a> "+
    					"<a href='/ChinaLife/guratee/terminate.do?id="+obj.id+"'>终止保单</a> "+"<a href='/ChinaLife/guratee/findGuranteeInfo.do?id="+obj.id+"'>查看详情</a>"		
    				+"</tr>";
    				
    			}
    			$("#data").html(str);
    			
    			<%--动态实现每一页显示的数相同--%>
    			if(pn == 1){
    				ops.totalPages = info.pages;
    				$("#pageUL").bootstrapPaginator(ops);
    			}
    		},"json")
    		
    		
    	}
    </script>
</head>
<body class="homepage">


     <div style="background-color: white;width: 70%;height: 500px;margin: auto">
         <div style="text-align: left;height: 130px;width: 100%;margin: auto">
             <h1>保单维护</h1><br>
             <form class="form-inline" id="f1">
                 <div class="form-group">
       	 受益人:<input type="text" name="favoree" class="form-control">
                 </div>
                 <div class="form-group">
                     起始日期:<input type="text" name="start" class="form-control">
                 </div>
                 <div class="form-group">
                     结束日期:<input type="text" name="end" class="form-control">
                 </div><br>
                 <div class="form-group">
                     险种编号:<input type="text"  name="number" class="form-control">
                 </div>
                 <div class="form-group">
                     签单人:<input type="text" name="signer" class="form-control">
                 </div>
                 <button type="button" class="btn btn-default" onclick="cut(1)"><span class="glyphicon glyphicon-search"></span>查询</button>
             </form>

         </div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>保险单号</th>
                    <th>受益人</th>
                    <th>投保人</th>
                    <th>投保日期</th>
                    <th>险种</th>
                    <th>签单人</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody id="data">
                <tr>
                    <td>2141241252</td>
                    <td>吕布</td>
                    <td>1998-04-21</td>
                    <td>人身意外保险</td>
                    <td>貂蝉</td>
                    <td><a href="apply.jsp">申请理赔</a> <a onclick="show()">终止保单</a>
                    <a href="chitMsg.jsp">查看</a></td>
                </tr>  
                </tbody>
            </table>
        </div>
        
        <div class="row">
	<div class="col-lg-12" style="font-size: 10px; text-align: center">
			<ul id="pageUL"></ul>
	</div>
	</div>
</html>