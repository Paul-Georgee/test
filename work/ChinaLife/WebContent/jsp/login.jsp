<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<head>
	<meta charset="utf-8">

	
	<link rel="stylesheet" href="/ChinaLife/css/bootstrap.min.css">
	<link rel="stylesheet" href="/ChinaLife/css/animate.css">
	<link rel="stylesheet" href="/ChinaLife/css/loginStyle.css">

	<script src="/ChinaLife/js/modernizr-2.6.2.min.js"></script>
	<script type="text/javascript">

	function changeImg() {
		$("#changeImg").attr("src","/ChinaLife/public/check.do?a="+Math.random());
	}

</script>
	</head>
	<body class="style-2">

		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<img src="/ChinaLife/images/logo.png">
				</div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					

					<!-- Start Sign In Form -->
					${loginError}
					<form action="/ChinaLife/public/login.do" method="post" class="fh5co-form animate-box" data-animate-effect="fadeInLeft" >
						<h2>请登录</h2>
						<div class="form-group">
							<input type="text" name="username" class="form-control" id="username" placeholder="用户名" autocomplete="off">
						</div>
						<div class="form-group">
							<input type="password" name="password" class="form-control" id="password" placeholder="密码" autocomplete="off">
						</div>
						<div class="form-group">
							<img src="/ChinaLife/public/check.do" id="changeImg"><br>
							<a href="javascript:changeImg()">看不清楚，换一张</a><br>
							请输入验证码：<input type="text" name="userCheck">${checkCode}<br>
						</div>
						<div class="form-group" style="text-align:right">
							<input type="submit" value="登录" class="btn btn-primary">
						</div>
					</form>
					<!-- END Sign In Form -->

				</div>
			</div>
			<div class="row" style="padding-top: 200px; clear: both;">
			</div>
		</div>
	
	<!-- jQuery -->
	<script src="/ChinaLife/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="/ChinaLife/js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="/ChinaLife/js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="/ChinaLife/js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="/ChinaLife/js/main.js"></script>

	</body>
</html>

