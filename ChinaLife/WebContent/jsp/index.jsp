<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>中国人寿保险</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <link href="/ChinaLife/css/liMarquee.css" rel="stylesheet" type="text/css" />
	<link href="/ChinaLife/css/default.css" rel="stylesheet" type="text/css" />
	<script src="/ChinaLife/assets/js/jquery.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <style type="text/css">
        .linear{
            background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(rgb(182,231,211)), to(#ffffff));
        }
        #main{
            width: 70%;
            /* height: 1200px; */
            position: relative;
            left: 220px;
        }
        #pmdDiv{

				position: absolute;
				right: 1%;
				top:200px;
				width: 12%;
				background-color: red;
				
			}
    </style>
    <script type="text/javascript">
    	$(function(){
    		notice();
    	})
    	
    	function notice(){
    		$.post("/ChinaLife/publicNotice/showAll.do",function(data){
    			var str="";
    			for (var i = 0; i < data.length; i++) {
    				var obj=data[i];
					str+="<a target='123' href='/ChinaLife/notice/show.do?id="+obj.id
							+"'>"+obj.title+"</a><br><br><br>";
				}
    			$("#notice").html(str);
    		},"json")
    	}
    </script>
</head>
<body class="homepage">
<div class="linear">
    <div id="page-wrapper" >

        <!-- Header -->
        <div id="header-wrapper">
            <header id="header" class="container">
                <!-- Logo -->
                <div id="logo">
                    <img src="/ChinaLife/assets/css/images/logo.png" height="50px" width="200px">
                </div>

                <!-- Nav -->
                <nav id="nav">
                    <ul style="padding-left: 0em;">
                        <li class="current"><a target="123" href="/ChinaLife/index.html">首页</a></li>
                        <li><a target="123" href="/ChinaLife/public/forum.do">电子论坛</a></li>
                        <li><span>我的邮箱</span>
                            <ul>
                                <li><a target="123" href="/ChinaLife/jsp/email/inbox.jsp">收件箱</a></li>
                                <li><a target="123" href="/ChinaLife/jsp/email/outbox.jsp">发件箱</a></li>
                            </ul>
                        </li>
                        <c:if test="${employee.role=='超级管理员' or employee.role=='管理员' }">
                        <li><span>管理员</span>
                            <ul>
                                <li><a target="123" href="/ChinaLife/jsp/admin/photo.jsp">视频管理</a></li>
                                <li><a target="123" href="/ChinaLife/jsp/admin/meeting.jsp">会议管理</a></li>
                                <li><a target="123" href="/ChinaLife/jsp/admin/Insurance.jsp">险种维护</a></li>
                                <li><a target="123" href="/ChinaLife/jsp/admin/notice.jsp">公告发布</a></li>
                                <li><a target="123" href="/ChinaLife/jsp/admin/train.jsp">员工培训</a></li>
                                <li><a target="123" href="/ChinaLife/jsp/admin/department.jsp">部门管理</a></li>
                                <li><a target="123" href="/ChinaLife/public/forum.do">论坛维护</a></li>
                                <li><a target="123" href="/ChinaLife/jsp/admin/regime.jsp">规章制度</a></li>
                                <li><a href="#">保单签订</a></li>
                            </ul>
                        </li>
                        </c:if>
                        <c:if test="${employee.role=='超级管理员' or employee.role=='部门负责人'}">
                        <li><span>部门负责人</span>
                            <ul>
                                <li><a target="123" href="/ChinaLife/jsp/section/showStaff.jsp">查看本部门员工</a></li>
                                <li><a target="123" href="/ChinaLife/jsp/section/preserve.jsp">本部门保单维护</a></li>
                                <li><a target="123" href="/ChinaLife/jsp/section/cake.jsp">本部门员工签单报表</a></li>
                            </ul>
                        </li>
                        </c:if>
                        <c:if test="${employee.role=='超级管理员' or employee.role=='业务员'}">
                        <li><span>普通员工</span>
                            <ul>
                                <li><a target="123" href="/ChinaLife/jsp/employee/personage/personage.jsp">个人签单</a></li>
                                <li><a target="123" href="/ChinaLife/jsp/employee/custormerDate/client.jsp">客户资料</a></li>
                            </ul>
                        </li>
                        </c:if>
                        <c:if test="${employee.role=='超级管理员' or employee.role=='领导' }">
                        <li><span>领导</span>
                            <ul>
                            	<li><a target="123" href="/ChinaLife/jsp/leader/meeting.jsp">会议管理</a></li>
                                <li><a target="123" href="/ChinaLife/jsp/leader/worker.jsp">员工信息</a></li>
                                <li><a target="123" href="/ChinaLife/jsp/leader/bill.jsp">所有保单</a></li>
                                <li><a target="123" href="/ChinaLife/jsp/leader/checkBill.jsp">审批理赔</a></li>
                                <li><a target="123" href="/ChinaLife/jsp/leader/performance.jsp">各部门业绩报表</a></li>
                            </ul>
                        </li>
                        </c:if>
                        <c:if test="${employee.role=='系统管理员' }">
                        <li><span>系统管理员</span>
                            <ul>
                                <li><a target="123" href="/ChinaLife/jsp/superadmin/userControl/userControl.jsp">用户管理</a></li>
                                <li>
                                    <span>日志管理</span>
                                    <ul>
                                        <li><a target="123" href="/ChinaLife/jsp/superadmin/log/loginLog.jsp">登录日志</a></li>
                                        <li><a target="123" href="/ChinaLife/jsp/superadmin/log/errorLog.jsp">错误日志</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        </c:if>
                        <c:if test="${!login }">
                        <li><span>${employee.username }</span>
                            <ul>
                                <li><a href="/ChinaLife/jsp/changePwd.jsp">修改密码</a></li>
                                <li><a href="/ChinaLife/jsp/login.jsp">退出登录</a></li>
                            </ul>
                        </li>
                        </c:if>
                        <c:if test="${ employee==null}" var="login">
						<li><span><a href="/ChinaLife/jsp/login.jsp">请登录</a></span></li></c:if>
                    </ul>
                </nav>
            </header>
        </div>
       <div id="pmdDiv" style=" height: 200px;">
								<div class="oneByOne_item" style="height: 300px;background-color: #0066ff;">
									<div class="htmleaf-content">
										<div class="str1 str_wrap" id="notice"  style="height:300px;width: 100%;background-color:  rgb(182,231,211)">
										
										</div>
								</div>
								</div>
		</div>
       <iframe src="/ChinaLife/index.html" frameborder="0" scrolling="no" id="main" onload="this.height=600" name="123"></iframe>
       
    </div>
</div>
<footer style="width: 50%;height: 30px;margin: auto;">
    Copyright © China Life Insurance Company Ltd. All Rights Reserved.
    <a href="#" target="_blank">京ICP备12003144号</a>
</footer>

<!-- Scripts -->
<script src="/ChinaLife/assets/js/jquery.min.js"></script>
<script src="/ChinaLife/assets/js/jquery.dropotron.min.js"></script>
<script src="/ChinaLife/assets/js/skel.min.js"></script>
<script src="/ChinaLife/assets/js/util.js"></script>
<script src="/ChinaLife/assets/js/main.js"></script>
<script src="/ChinaLife/js/jquery.liMarquee.js"></script>
<script type="text/javascript">
		function reinitIframe(){
		var iframe = document.getElementById("main");
		try{
		var bHeight = iframe.contentWindow.document.body.scrollHeight;
		var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
		var height = Math.max(bHeight, dHeight);
		iframe.height = height;
		console.log(height);
		}catch (ex){}
		}
		window.setInterval("reinitIframe()", 200);
		$(window).load(function(){
			$('.str1').liMarquee({
				direction: 'up'
			});
			$('.str2').liMarquee({
				direction: 'down'
			});
		});
		</script>
</body>
</html>