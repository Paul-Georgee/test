<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>会议详情</title>
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
</head>
<body>
    <div class="row"style="height: 300px;width: 70%;margin: auto;">
        <h1>${meeting.title}</h1><br><br><br>
        <div class="col-md-1" ></div>
        <div class="col-md-4" >
            <h4>会议时间:${meeting.huiyiTime}</h4>
        </div>
        <div class="col-md-7" >
            <h4>与会人员:${meeting.conferee}</h4>
        </div>

        <div class="col-md-1" ></div>
        <div class="col-md-4" >
            <h4>会议地点:${meeting.location}</h4>
        </div>
        <div class="col-md-7" >
            <h4>会议结果:${meeting.content}</h4>
        </div>

        <div class="col-md-1"></div>
        <div class="col-md-4">
            <h4>会议状态:${meeting.state}</h4>
        </div>

    </div><br><br><br><br><br><br><br><br>
    <div style="height: 50px;width: 70px;margin: auto">
       <a href="/ChinaLife/jsp/admin/meeting.jsp" class="btn btn-primary btn-lg active" role="button">返回</a>
    </div>

</body>
</html>