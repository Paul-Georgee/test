<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

    <link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>

    <style type="text/css">
        .linear{
            background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(rgb(182,231,211)), to(#ffffff));/*谷歌*/
        }
        #div1{
            display: none;
         }
        .content{
        	margin-left:80px;
            height: 600px;
            width: 1000px;
            right: 80px;
            top: 10px;
            opacity: 0.9;
            z-index: 80;
        }
  

    </style>

</head>
<body class="homepage">
<div class="linear">
    <div id="page-wrapper" >

        <!-- Header -->
        <div id="header-wrapper">
            <header id="header" class="container">

                <!-- Logo -->
                <div id="logo">
                    <img src="../../assets/css/images/logo.png" height="50px" width="200px">
                </div>

                <!-- Nav -->
                <nav id="nav">
                    <ul>
                        <li class="current"><a href="myindex.html">首页</a></li>
                        <li><a href="#">电子论坛</a></li>
                        <li><a href="">我的邮箱</a>
                            <ul>
                                <li><a href="#">收件箱</a></li>
                                <li><a href="#">发件箱</a></li>
                                <li>
                                    <a href="#">垃圾箱</a>
                                </li>
                                <li><a href="#">草稿箱</a></li>
                            </ul>
                        </li>
                        <li><a href="javascript:jump('meeting')">会议查看</a></li>
                        <li>
                            <a href="#">领导</a>
                            <ul>
                                <li><a href="javascript:jump('worker')" >员工信息</a></li>
                                <li><a href="javascript:jump('bill')">所有保单</a></li>
                                <li><a href="javascript:jump('checkBill')">审批理赔</a></li>
                                <li><a href="javascript:jump('performance')">各部门业绩报表</a></li>
                            </ul>
                        </li>
                        <li><a href="#">张三</a>
                            <ul>
                                <li><a href="#">修改密码</a></li>
                                <li><a href="#">退出登录</a></li>
                            </ul>
                        </li>

                    </ul>
                </nav>
            </header>
        </div>
        
        <div id="contentDiv" class="container">
        	<iframe id="iframe1" class="content"  scrolling="no" ></iframe>
        </div>
        <div id="div1" style="background-color: white;width: 70%;height: 500px;margin: auto">
            <table class="table table-striped">
                <tr>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>工资</td>
                </tr>
                <tr>
                    <td>张三</td>
                    <td>男</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>张三</td>
                    <td>男</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>张三</td>
                    <td>男</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>张三</td>
                    <td>男</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>张三</td>
                    <td>男</td>
                    <td>100</td>
                </tr>
            </table>
        </div>
    </div>
</div>
<footer style="width: 45%;height: 500px;margin: auto" class="container">
	<div style="margin-left:100px;" >
		Copyright © China Life Insurance Company Ltd. All Rights Reserved.
    	<a href="#" target="_blank">京ICP备12003144号</a>
	</div>
</footer>

<script>

    function jump(pn){
        $("#iframe1").attr("src",pn+".jsp");
    }

</script>

<!-- Scripts -->
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/js/jquery.dropotron.min.js"></script>
<script src="../../assets/js/skel.min.js"></script>
<script src="../../assets/js/util.js"></script>
<script src="../../assets/js/main.js"></script>
</body>

</html>