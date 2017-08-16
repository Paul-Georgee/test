<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="/ChinaLife/css/bootstrap.min.css">
	<link rel="stylesheet" href="/ChinaLife/css/animate.css">
	<link rel="stylesheet" href="/ChinaLife/css/loginStyle.css">

	<script src="/ChinaLife/js/modernizr-2.6.2.min.js"></script>
	</head>
	<body class="style-2">

		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<img src="/ChinaLife/images/logo.png">
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">

				</div>
				<div class="col-md-4">
					

					<!-- Start Sign In Form -->
<form class="fh5co-form animate-box" data-animate-effect="fadeInLeft" 
					 action="/ChinaLife/employee/changePwd.do" method="post">
						<h2>修改密码</h2>
						<div class="form-group">
							<div class="alert alert-success" role="alert">用户名:${employee.username }</div>
						</div>
						<div class="form-group">
							<input type="hidden" class="form-control"  autocomplete="off" name="userId" value="${employee.id }">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="password" placeholder="新密码" autocomplete="off" name="password">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="re-password" placeholder="确认新密码" autocomplete="off" name="confirmPwd">
						</div>
						<div class="form-group">
							<input type="submit" value="确认修改" class="btn btn-primary">
						</div>
					</form>
				</div>
			</div>
			<div class="row" style="padding-top: 100px; clear: both;">
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

